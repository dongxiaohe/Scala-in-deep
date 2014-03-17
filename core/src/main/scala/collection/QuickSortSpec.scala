package collection

object QuickSortSpec {

  def sort(list: List[Int]) : List[Int] = {

    case object SortElements {
      def unapply(list : List[Int]) = {
        val ele = list(list.size / 2)
        Some(list.filter(_ < ele), list.filter(_ == ele), list.filter(_ > ele))
      }
    }

    list match {
      case Nil => list
      case SortElements(x, y, z) => sort(x) ::: y ::: sort(z)
    }

  }

}
