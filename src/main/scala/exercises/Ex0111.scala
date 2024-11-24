package exercises

import zio.*
import java.io.PrintWriter
import java.io.File

object Ex0111 extends ZIOAppDefault:
  def readFileZIO(file: String): ZIO[Scope, Throwable, String] =
    ZIO
      .fromAutoCloseable(ZIO.attempt(scala.io.Source.fromFile(file)))
      .map(_.getLines.mkString("\n"))

  def writeFileZIO(file: String, text: String): ZIO[Scope, Throwable, Unit] =
    ZIO
      .fromAutoCloseable(ZIO.attempt(new PrintWriter(new File(file))))
      .map(_.write(text))

  def copyFileZIO(source: String, dest: String): ZIO[Scope, Throwable, Unit] =
    readFileZIO(source).flatMap(writeFileZIO(dest, _))

  def run: ZIO[Environment & (ZIOAppArgs & Scope), Any, Any] =
    copyFileZIO("README.md", "target/README.md")
