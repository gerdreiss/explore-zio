package exercises.chapter02.ex02

import zio.*
import zio.test.*

object SimpleCacheSpec extends ZIOSpecDefault:
  def spec = suite("Chapter 2 Exercise 2 - Simple cache")(
    test("Caches and retrieves non-expired items") {
      for
        key    <- SimpleCache.addItem("1")
        result <- SimpleCache.getItem(key)
      yield assertTrue(result == Some("1"))
    },
    test("Caches and expires items") {
      for
        keyFiber    <- SimpleCache.addItem("2").fork
        _           <- TestClock.adjust(2.hour)
        key2        <- keyFiber.join
        resultFiber <- SimpleCache.getItem(key2).fork
        result2     <- resultFiber.join
      yield assertTrue(result2 == None)
    },
  )
