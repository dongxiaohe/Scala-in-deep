package design.visitor

import java.nio.file.attribute.BasicFileAttributes
import java.nio.file._

import scala.collection.mutable.ArrayBuffer

object FileVisitor {

  def main(args: Array[String]) {

    val files = ArrayBuffer.empty[Path]

    val root = Paths.get("./core/src/main/scala")

    Files.walkFileTree(root, new SimpleFileVisitor[Path] {
      override def visitFile(file: Path, attrs: BasicFileAttributes) = {
        if (file.getFileName.toString.endsWith(".scala")) {
          files += file
        }
        FileVisitResult.CONTINUE
      }
    })

    files.foreach(println)

  }

}
