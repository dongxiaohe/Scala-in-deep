package design.implicits$.generic

import org.scalatest.FunSuite

import shapeless._
import Nat._

class HasChecksumTest extends FunSuite {

  test("checksum in compile time") {

//    trait HasChecksum[L <: HList, S <: Nat]
//
//    implicit object hnilHasChecksum extends HasChecksum[HNil, _0]
//
//    implicit def hlistHasChecksum[
//    H <: Nat, T <: HList, S <: Nat,
//    TS <: Nat, TL <: Nat,
//    HP <: Nat, HS <: Nat
//    ](
//       implicit
//       st: HasChecksum[T, TS],
//       tl: LengthAux[T, TL],
//       hp: ProdAux[H, Succ[TL], HP],
//       hs: SumAux[HP, TS, HS],
//       sm: ModAux[HS, _11, S]
//       ) = new HasChecksum[H :: T, S] {}
//
//    def isValid[L <: HList](implicit l: LengthAux[L, _9], c: HasChecksum[L, _0]) = ()
//
//    println(isValid[_3 :: _4 :: _5 :: _8 :: _8 :: _2 :: _8 :: _6 :: _5 :: HNil])

//    this sequence not
//    isValid[_3 :: _1 :: _5 :: _8 :: _8 :: _2 :: _8 :: _6 :: _5 :: HNil]

  }

}
