package core.either$

import org.scalatest.FunSuite
import java.net.{URL, MalformedURLException}

class BasicSpec extends FunSuite {

  test("either spec") {
    import scala.io.Source
    import java.net.URL
    def getContent(url: URL): Either[String, Source] =
      if (url.getHost.contains("google"))
        Left("Requested URL is blocked for the good of the people!")
      else
        Right(Source.fromURL(url))

    val content: Either[String, Iterator[String]] =
      getContent(new URL("http://danielwestheide.com")).right.map(_.getLines())

    println(content.right.get.toList.init)

    val moreContent: Either[String, Iterator[String]] =
      getContent(new URL("http://google.com")).right.map(_.getLines())

//    println(moreContent.right.get)

    val result = List(1,2,3).map(Iterator(_))

    println(result)
  }

  test("handle particular exception") {
    import scala.util.control.Exception._

    def handling[Ex <: Throwable, T](exType: Class[Ex])(block: => T): Either[Ex, T] =
      catching(exType).either(block).asInstanceOf[Either[Ex, T]]

    def parseUrl(url: String): Either[MalformedURLException, URL] = handling(classOf[MalformedURLException])(new URL(url))


    assert(parseUrl("http://www.google.com").isRight)
    assert(parseUrl("google").isLeft)
  }

  test("either in collections") {
    type Citizen = String
    case class BlackListedResource(url: URL, visitors: Set[Citizen])

    val blacklist = List(
      BlackListedResource(new URL("https://google.com"), Set("John Doe", "Johanna Doe")),
      BlackListedResource(new URL("http://yahoo.com"), Set.empty),
      BlackListedResource(new URL("https://maps.google.com"), Set("John Doe")),
      BlackListedResource(new URL("http://plus.google.com"), Set.empty)
    )

    val checkedBlacklist: List[Either[URL, Set[Citizen]]] =
      blacklist.map(resource =>
        if (resource.visitors.isEmpty) Left(resource.url)
        else Right(resource.visitors))

    val suspiciousResources = checkedBlacklist.flatMap(_.left.toOption)
    val problemCitizens = checkedBlacklist.flatMap(_.right.toOption).flatten.toSet

    println(suspiciousResources)
    println(problemCitizens)
  }

}
