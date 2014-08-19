package akka$

import akka.actor.ActorSystem
import akka.stream.{MaterializerSettings, FlowMaterializer}
import akka.stream.scaladsl.Flow
import scala.concurrent.duration._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by xueli on 20/08/2014.
 */
object basicReactiveStream extends App {


  def doStuff = {
    Thread.sleep(300)
    3
  }


  implicit val system = ActorSystem("System")

  val value: FlowMaterializer = FlowMaterializer(MaterializerSettings())



  val flow  = Flow(() => doStuff).toPublisher(value)

  case object Tick

  val tick = Flow(1.second, () => Tick)

  tick.zip(flow).mapFuture{
    case t => Future(t)
  }.foreach(println).consume(value)


}
