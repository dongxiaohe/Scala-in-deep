package design.implicits$


object MainClass {


  def main(args: Array[String]) {

    TestModel.manyToJSON(Nil)
  }
}

case class TestModel(test:String)

object TestModel {

  def manyToJSON(models: List[TestModel]) = {
    import writes._
    def print(implicit x: Int) = {
      println(x)
    }

    val result: List[Any] = List(List(1, 2, 3), List("1", "2", "3")).flatMap(x => x)
    println(result)

    println(Ordering[Int].compare _)

    println(Set(List(1,2,3)))

    print
  }

  object writes {
    implicit val x: Int = 3
  }

}
