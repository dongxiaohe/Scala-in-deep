package design.implicits$.spike

class Talkative {

  def talk(): Unit = println("hello world")

  implicit def takeTime(x: String): Talkative = new Talkative

}

object Talkative {
  
  implicit def takeTime(x: String): Talkative = new Talkative
  
}
