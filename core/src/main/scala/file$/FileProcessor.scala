package file$

import java.io._
import java.security._
import scala.annotation.tailrec

class FileProcessor {

  def calculateHash(algorithm: MessageDigest, in: String, limit: Int): Option[Array[Byte]] = {

    val input = new ByteArrayInputStream(in.getBytes())
    val dis = new DigestInputStream(input, algorithm)

    @tailrec
    def read(total: Int): Option[Array[Byte]] = {
      if (total > limit) None
      else {
        val byte = dis.read()
        if (byte == -1) Some(algorithm.digest())
        else read(total + 1)
      }
    }
    read(0)
  }

}
