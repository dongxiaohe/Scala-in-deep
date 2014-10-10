package scalatest$

case class RankBusiness[W <: DefaultRank](x: W) {
  
  def process(client: Client[W]) = {
    client.doStuff()
  }
}

trait Client[T <: DefaultRank] {
  def doStuff() = {
    println("default rank client")
  }
}

trait DefaultRank

case class FirstRank() extends DefaultRank
case class SecondRank() extends DefaultRank
case class ThirdRank() extends DefaultRank

object MainApp {

  def main(args: Array[String]) {

    new RankBusiness(new DefaultRank {}).process(new Client[DefaultRank] {})

  }

}