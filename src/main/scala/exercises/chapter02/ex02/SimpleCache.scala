package exercises.chapter02.ex02

import scala.collection.mutable.Map as MutableMap
import zio.*

import java.util.UUID
import java.time.Instant

object SimpleCache:
  case class Item(value: String, expiry: Instant)

  private val validity: Duration = 1.hour // this would come from configuration

  private val cache: MutableMap[UUID, Item] = MutableMap.empty

  def addItem(value: String): UIO[UUID] =
    Clock.currentDateTime.map { now =>
      val key  = UUID.randomUUID()
      val item = Item(value, now.plus(validity).toInstant())
      cache.put(key, item)
      key
    }

  def getItem(key: UUID): UIO[Option[String]] =
    Clock.currentDateTime.map { now =>
      cache.get(key) match
        case Some(item) if item.expiry.isAfter(now.toInstant()) =>
          Some(item.value)
        case Some(item)                                         =>
          cache.remove(key)
          None
        case None                                               =>
          None
    }
