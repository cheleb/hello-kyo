package kit

import kyo.*

val program =
  for
    _ <- Console.printLine("Hello, World!")
    _ <- Console.printLine("Bye, World!")
  yield ()

val env: Int < (Env[Int] & (Abort[String] & Sync)) = for
  i <- Env.get[Int]
  _ <- Abort.when(i < 0)("Negative value")
  _ <- Console.printLine(s"Read $i form environment")
yield i

val seq = for
  i <- Env.get[Int]
  multiple <- Kyo.fromSeq(1 to 10).map(_ * i)
  _ <- Aborts.when(multiple < 100)("To big value")
  _ <- Console.printLine(s"Read $multiple from environment")
yield i

object Main extends KyoApp:
  run:
    program
  run:
    Env.run(-42):
      Abort.run:
        env
  run:
    Env.run(42):
      Choice.run:
        Abort.run:
          seq
