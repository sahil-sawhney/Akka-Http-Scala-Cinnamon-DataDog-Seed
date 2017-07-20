package com.example.actors

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import com.example.models.Product

class ComputeTotalActor extends Actor with ActorLogging {

  val allotDistributorActor: ActorRef = context.actorOf(Props[AllotDistributorActor], "allot_distributor_actor")

  override def receive: PartialFunction[Any, Unit] = {
    case productDetail: Product =>
      val totalPrice: Double = computeTotalWithDiscount(productDetail.name, productDetail.quantity)
      log.info(s"Payable Price for your order is $totalPrice")
      allotDistributorActor ! productDetail.copy(payblePrice = totalPrice)
    case _ => log.error("There was an error computing total payable price of your order")
  }

  private def computeTotalWithDiscount(name: String, quantity: Int): Double = {
    10.5d //Provide your computation logic here
  }

}

object ComputeTotalActor {
  val props: Props = Props[ComputeTotalActor]
}