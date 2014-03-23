package design.chain

class Context[T](proc: () => T) {

  def apply[T]() = proc()

  def and[U](that : () => U) : Context[U] = {
    new Context[U](() => {proc(); that()})
  }

  def andThen[U](that: () => Context[U]) = {
    new Context[U](() => {proc(); that()()})
  }

  def map[U](func : T => U) = {
    new Context[U](() => func(proc()))
  }

}

object Context {

  def apply[T](proc : () => T) = new Context(proc)

}
