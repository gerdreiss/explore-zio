import zio.*

object Playground extends ZIOAppDefault:

  override def run: ZIO[Any & (ZIOAppArgs & Scope), Any, Any] =
    zio.Console.printLine("Hello from ZIO")
