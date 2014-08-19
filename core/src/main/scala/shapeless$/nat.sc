import shapeless._, nat._, ops.nat.Mod, ops.nat.Sum

import scala.annotation.implicitNotFound
import scala.util.Try

def myFunction[N <: Nat, R <: Nat](n: N)
        (implicit mod: Mod.Aux[N, _3, R], neq: R =:!= _3) = n

myFunction(_3)

@implicitNotFound("The sum of 2 NAT values should not equal 7 ($T + $W == 7)")
def typeSafeSum[T <: Nat, W <: Nat, R <: Nat](x: T, y: W)
         (implicit sum: Sum.Aux[T, W, R], error: R =:!= _7) = x

typeSafeSum(_3, _4)