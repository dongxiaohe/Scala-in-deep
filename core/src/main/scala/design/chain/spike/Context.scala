package design.chain.spike

trait Chain {
//  def fn[T, W]: Context[T] => Context[W]
}

class Context[T](x: () => T) extends Chain {

  def apply() = x

//  def fn[T, W] = Context(x) => Context(x)

  def andThen[W](proc: Context[W]): Context[W] = {
    new Context[W](() => {x(); proc()()})
  }

}

object Context {
  def apply[T](x: () => T) = new Context[T](x)
}

object main {

  def main(args: Array[String]) = {

    val result = Context(() => {println("processing int");3}) andThen Context(() => {println("processing string");"3"})

    println("start processing............")

    result()()

    println("finish processing............")
  }


}


