val func = (x: Int) => x + 1

val foo = Function.chain(List.fill(3)(func))

foo