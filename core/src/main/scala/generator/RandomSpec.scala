package generator

import scala.util.Random

object RandomSpec {
  def generate() : Int = new Random().nextInt(101)


}
