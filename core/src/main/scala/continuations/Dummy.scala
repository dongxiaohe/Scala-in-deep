package continuations

object Dummy {

  def sort(x: List[Int]): List[Int] = {

    case object Elements {
      def unapply(list: List[Int]) = {
        val ele = list(list.size / 2)
        Some(list.filter(_ < ele), list.filter(_ == ele), list.filter(_ > ele))
      }
    }

    x match {
      case Nil => x
      case Elements(x, y, z) => sort(x) ::: y ::: sort(z)
    }

  }

}
