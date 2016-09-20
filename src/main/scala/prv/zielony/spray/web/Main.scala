package prv.zielony.spray.web

import akka.actor.ActorSystem
import spray.http.MediaTypes._
import spray.routing.SimpleRoutingApp

/**
  * Created by Zielony on 2016-09-20.
  */
object Main extends App with SimpleRoutingApp {

  import scala.concurrent.ExecutionContext.Implicits._

  implicit val actorSystem = ActorSystem("SprayWeb");

  startServer("localhost", 9990) {
    path("monitoring") {
      getFromResource("web/index.html")
    } ~ {
      getFromResourceDirectory("web")
    } ~
    path("monitoring" / Segment) { id =>
      respondWithMediaType(`application/json`) {
        complete("""{"name": "Kamil", "surname": "Owczarek"}""")
      }
    }
  }
}