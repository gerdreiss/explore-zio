package exercises.chapter02.ex01

import zio.*

object CountdownPrinter:
  def printNumbers(from: Int, delay: Duration): Task[Unit] =
    if from <= 0 then ZIO.unit
    else
      Clock.sleep(delay) *>
        Console.printLine(from) *>
        printNumbers(from - 1, delay)
