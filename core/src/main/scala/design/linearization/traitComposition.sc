import scala.concurrent.Future

class P(name:String)

trait SysConfig {
  def prop(key:String) = System.getProperty(key)
}

class C extends P("123") with SysConfig {
  override def prop(key: String) = "123"
}

trait Foo extends P with SysConfig {
  override def prop(key: String) = "123"
}

new C

//type block = Future

val ns: Iterator[Int] = (1 to 3).iterator
val result = ns.map(_ => () => Future)

result.foreach(_())