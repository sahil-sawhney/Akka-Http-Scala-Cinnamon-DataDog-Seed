package com.example

import akka.http.scaladsl.server.{ HttpApp, Route }

object WebServerHttpApp extends HttpApp with App {

  def routes: Route =
    pathEndOrSingleSlash {
      complete("Server up and running")
    } ~
      path("hello") {
        get {
          complete("Hello world")
        }
      }

  startServer("localhost", 8080)
}
