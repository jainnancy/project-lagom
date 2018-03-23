package main.scala.edu.knoldus.hello.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.{Descriptor, Service, ServiceCall}

object HellolagomService {
  val TOPIC_NAME = "hello"
}

trait HellolagomService extends Service {

  def sayHello(name: String): ServiceCall[NotUsed,String]

  override def descriptor: Descriptor = {
    import Service._
    named("hello-lagom")
        .withCalls(
          pathCall("/api/hello/:name",sayHello _)
        )
      .withAutoAcl(true)
  }
}
