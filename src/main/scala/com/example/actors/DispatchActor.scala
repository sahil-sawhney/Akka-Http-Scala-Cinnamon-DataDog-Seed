package com.example.actors

import akka.actor.{Actor, ActorLogging, Props}
import com.example.models.Product

class DispatchActor extends Actor with ActorLogging{

  override def receive: Receive = {
    case productDetail:Product =>
      val deliveryDate = estimateDeliveryDate
      log.info(s"Your order would be delivered $deliveryDate")

    case _ => log.error("Your product cant be delivered as no dates are free")
  }

  def estimateDeliveryDate = {
    "Tommorow"
  }

}

object DispatchActor {
  val props:Props = Props[DispatchActor]
}
