import zio.*

object Playground extends ZIOAppDefault:

  override def run: ZIO[Any & (ZIOAppArgs & Scope), Any, Any] =
    Console.printLine("Hello from ZIO")
