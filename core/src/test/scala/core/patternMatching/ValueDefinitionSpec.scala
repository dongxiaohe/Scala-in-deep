package core.patternMatching

import org.scalatest.FunSuite

class ValueDefinitionSpec extends FunSuite {

  test("value definition") {
    case class Person(name: String, age: Int)

    val Person(name, _) = Person("Daniel", 23)

    println(name)

    val (_, _, c) = (1, 2, 3)

    println(c)

    def gameResults(): Seq[(String, Int)] =
      ("Daniel", 3500) :: ("Melissa", 13000) :: ("John", 7000) :: Nil

    def hallOfFame = for {
      (name, score) <- gameResults()
      if (score > 5000)
    } yield name

    println(hallOfFame)

    val lists = List(1, 2, 3) :: List.empty :: List(5, 4) :: Nil

    val result = for {
      list @ head :: _ <- lists
    } yield list

    println(result)
  }

}
