Seq(1,2,3).transpose(t => Seq(t))

val result = Array((1,Array(1.0,0.0,5.2,0.0)), (1,Array(1.0,0.0,6.3,0.0)), (2,Array(0.0,1.0,0.0,1.2)), (2,Array(0.0,1.0,0.0,2.5)))

result.groupBy(_._1).mapValues(_.map(t => t._2).transpose.map(_.sum).toList).toList














//result.groupBy(_._1).mapValues(_.map(_._2).transpose.map(_.sum)).toArray
//
//def sum3(a: Int)(b: Int)(c: Int): Int = a + b + c
//
//val g: Int => Int => Int = sum3(10) _
//val h: Int => Int        = g(20)
//val r: Int               = h(30)
//
//def adder(x: Int)(y: Int) = x + y
//
//Seq(1, 2, 3, 4) map adder(30)
//
//val list = List(1,3,6,9)
//
//def findBounds(i: Int, a: List[Int]) =
//  a.sliding(3).toList.find(a => a.head <= i && a.last >= i)
//
//val foo = Map("abc" -> List(1,2,3)).map {case (t, w) => w.map(t -> _)}.toList
//
//foo.transpose
