def f(i: Int): Option[String] = i match {
  case 1 => Some("1")
  case 2 => Some("2")
  case 3 => Some("3")
  case _ => None
}

def g(i: Int) : String = f(i).getOrElse("X")


def f_1 : PartialFunction[Int, String] = {
  case 1 => "1"
}

def f_2 : PartialFunction[Int, String] = {
  case 2 => "2"
}

def f_3 : PartialFunction[Int, String] = {
  case 3 => "3"
}

//def g_(i: Int) : String = f_.orElse { case _ => "X" }(i)


val result = f_1.orElse(f_2).orElse(f_3)
//def g_(i: Int) : String = result.orElse { case _ => "X" }(i)

val str = "a,b,this is a test"

val Array(x, y, _*) = str.split(",")