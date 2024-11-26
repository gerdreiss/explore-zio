package exercises.chapter02.ex01

import zio.*
import zio.test.*

object CountdownPrinterSpec extends ZIOSpecDefault:

  def spec = suite("Chapter 2 Exercise 1 - Countdown printer")(
    test("Countdown prints appropriate number of counts") {
      for
        fiber  <- CountdownPrinter.printNumbers(5, 1.second).fork
        _      <- TestClock.adjust(5.seconds)
        result <- fiber.join
        output <- TestConsole.output
      yield assertTrue(output == Vector("5\n", "4\n", "3\n", "2\n", "1\n"))
    }
  )
