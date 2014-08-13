import scala.collection.parallel.immutable.ParSeq
//val intParList: ParSeq[Int] = (1 to 100000)
//  .map(_ => scala.util.Random.nextInt()).par
//
//var start = System.currentTimeMillis()
//intParList.reduce(_ + _)
//var end = System.currentTimeMillis()
//
//end - start
//
//start = System.currentTimeMillis()
//intParList.fold(0)(_ + _)
//end = System.currentTimeMillis()
//
//end - start
//List(4, 10, 3).fold(360)(_ / _)
//List.tabulate(7)(_ + 1).fold(1000000)(_ / _)
//(List(1000000.0) ::: List.tabulate(100)(_ + 0.001)).reduce(_ / _)

class SuperBase

class Base extends SuperBase

class SubBase extends Base

val add: Function1[Base, Base] = { base =>
  new SubBase
}

add(new SubBase)

val result: SuperBase = add(new SubBase)