package com.example.actors

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import com.example.models.Product

class AllotDistributorActor extends Actor with ActorLogging {

  val dispatchActor: ActorRef = context.actorOf(Props[DispatchActor], "dispatch_actor")

  override def receive: PartialFunction[Any, Unit] = {
    case productDetail:Product =>
      val allocatedDeliveryGuy = allocateDeliveryGuyForOrder
      log.info(s"$allocatedDeliveryGuy is your alloted delivery guy")
      dispatchActor ! productDetail.copy(deliveryGuy=allocatedDeliveryGuy)
    case _ => log.error("Delivery guy cant be allocated for your order")
  }

  private def allocateDeliveryGuyForOrder:String = {
    "Deepak"  //Your logic to allocate a delivery guy comes here
  }

}

object AllotDistributorActor {
  val props: Props = Props[AllotDistributorActor]
}