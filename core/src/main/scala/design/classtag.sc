import scala.reflect.ClassTag
def foo[T](implicit t: ClassTag[T]): List[T] = {
  println(t.runtimeClass)
  Nil
}
val x: List[String] = foo //classTag is a lie
