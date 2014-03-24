package design.implicits.scope

object GenericAddSpec {
  def add[T](x: T, y: T)(implicit spec : GenericAdd[T]) : T = spec.add(x, y)

  sealed trait GenericAdd[T] {
    def add(x: T, y: T) : T
  }

  implicit object stringGenericAdd extends GenericAdd[String] {
    override def add(x: String, y: String): String = x + " " + y
  }

  implicit object intGenericAdd extends GenericAdd[Int] {
    override def add(x: Int, y: Int): Int = x + y
  }

}
