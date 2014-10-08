class Bounded[A] { class i[C <: A]{ type apply = C}}

type TTT = Bounded[Any]#i[Int]#apply

implicitly[TTT =:= String]