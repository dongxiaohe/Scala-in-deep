import shapeless._, nat._, ops.nat.Mod, ops.nat.Sum

def myFunction[N <: Nat, R <: Nat](n: N)
        (implicit mod: Mod.Aux[N, _3, R], neq: R =:!= _3) = n

myFunction(_3)

@annotation.implicitNotFound(msg = "No Props instance for ${T}")
def typeSafeSum[T <: Nat, W <: Nat, R <: Nat](x: T, y: W)
         (implicit sum: Sum.Aux[T, W, R], error: R =:!= _7) = x

typeSafeSum(_3, _4)