package rxscala$

import rx.lang.scala._
import rx.lang.scala.schedulers._
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import scala.concurrent.Await
import scala.collection.mutable
import scala.concurrent.duration.Duration
import scala.concurrent.duration.DurationInt
import scala.concurrent.duration.DurationLong
import scala.language.postfixOps
import scala.language.implicitConversions

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Ignore
import org.junit.Test
import org.scalatest.junit.JUnitSuite

object RxScalaTest {

  def main(args: Array[String]) {
    val o = Observable.interval(200 millis).take(4)
    o.subscribe(n => println("n = " + n))
    println(Observable.items(3, 6, 9).foldLeft(3)(_ + _))

    val first = Observable.items(10, 11, 12)
    val second = Observable.items(10, 11, 12)
    val booleans = for ((n1, n2) <- (first zip second)) yield (n1 == n2)


    val items = Observable.items(1, 2, 3)

    // Generally, we have two methods, `subscribe` and `foreach`, to listen to the messages from an Observable.
    // `foreach` is just an alias to `subscribe`.
    items.subscribe(
      n => println(n),
      e => e.printStackTrace(),
      () => println("done")
    )


    Thread.sleep(5000)
  }

}
