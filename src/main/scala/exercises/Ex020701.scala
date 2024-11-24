package exercises

import zio.*

object Ex020701 extends ZIOAppDefault:

  def printNumbers(from: Int, delay: Duration): Task[Unit] =
    if from <= 0 then ZIO.unit
    else
      Clock.sleep(delay) *>
        Console.printLine(from) *>
        printNumbers(from - 1, delay)

  override def run = printNumbers(5, 1.second)
