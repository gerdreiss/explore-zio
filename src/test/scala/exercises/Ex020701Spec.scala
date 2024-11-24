package exercises

import zio.*
import zio.test.*

object Ex020701Spec extends ZIOSpecDefault:

  def spec = suite("Exercise 2.7.1")(
    test("Countdown prints appropriate number of counts") {
      for
        fiber  <- Ex020701.printNumbers(5, 1.second).fork
        _      <- TestClock.adjust(5.seconds)
        result <- fiber.join
        output <- TestConsole.output
      yield assertTrue(output == Vector("5\n", "4\n", "3\n", "2\n", "1\n"))
    }
  )
