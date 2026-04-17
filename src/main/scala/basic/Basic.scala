package basic

import kyo.*

object Basic extends KyoApp:
  // Use 'run' blocks to execute Kyo computations.
  // The execution of the run block is lazy to avoid
  // field initialization issues.

  val a: 1 < Any = 1

  run {
    for
      one <- a
      _ <- Console.printLine(s"$one Main args: $args")
      currentTime <- Clock.now
      _ <- Console.printLine(s"Current time is: $currentTime")
      randomNumber <- Random.nextInt(100)
      _ <- Console.printLine(s"Generated random number: $randomNumber")
    yield
    // The produced value can be of any type and is
    // automatically printed to the console.
    "example"
  }
end Basic
