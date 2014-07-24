package file$

import java.security.MessageDigest

import org.scalatest.FunSuite

class FileProcessorTest extends FunSuite {

  test("file processor read a file") {

    val sha1 = MessageDigest.getInstance("SHA1")

    val processor = new FileProcessor()

    println(new String(sha1.digest(processor.calculateHash(sha1, "Hello", 5).get)))
    println(processor.calculateHash(sha1, "Too long", 5))

  }

}
