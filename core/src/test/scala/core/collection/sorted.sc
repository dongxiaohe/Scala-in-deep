def sorted(l:List[Int]) = l.view.zip(l.tail).forall(x => x._1 <= x._2)

Seq(1,2,3)


sorted(List(1,2,3))