package com.example

import akka.actor.ActorSystem
import akka.http.scaladsl.server.{HttpApp, Route}
import com.example.actors.ComputeTotalActor
import com.example.models.Product

object WebServerHttpApp extends HttpApp with App{

  val system = ActorSystem("OnlineShoppingActorSystem")

  val computeTotalActor = system.actorOf(ComputeTotalActor.props, "compute_total_actor")

  def routes: Route =
    pathEndOrSingleSlash {
      complete("Server up and running")
    } ~
      path("order") {
        get {
          parameter('name.?, 'quantity.?) { (name, quantity) =>
            complete(processProductDelivery(name, quantity))
          }
        }
      }

  private def processProductDelivery(productName: Option[String], productQuantity: Option[String]): String = {
    (productName, productQuantity) match {
      case (Some(name), Some(quantity)) => computeTotalActor ! Product(name, quantity.toInt)
        s"Your order for ${quantity.toInt} ${name}s is processing..."
      case _ => "Faulty!!! Please provide name and quantity of product you want to purchase"
    }
  }

  startServer("localhost", 9001)
}
