package edu.knoldus.hello.impl

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.ServiceCall
import main.scala.edu.knoldus.hello.api.HellolagomService

import scala.concurrent.Future

class HellolagomServiceImpl extends HellolagomService{
  override def sayHello(name: String): ServiceCall[NotUsed, String] = {
    _ =>
      Future.successful("Hello!! " + name )
  }
}
