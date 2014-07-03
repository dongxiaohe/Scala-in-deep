val list = List(1,2,3)
list match {
  case head :: tail => println(s"h:${head} ~ t: ${tail}")
  //  case Nil =>
}
