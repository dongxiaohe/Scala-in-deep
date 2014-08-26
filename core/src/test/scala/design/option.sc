Some("123") map (_ => "123123123")

import scalaz._, Scalaz._

(List("foo","bar") |@| List("baz","qux")) { _ |+| _ }

(List("foo","bar") |+| List("baz","qux"))

(_: Int) +1

List(some(1),some(2),some(3), none).sequence

List((_: Int) +1)