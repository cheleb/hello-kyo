package basic

import kyo.*
import kyo.kernel.*

sealed trait Ask extends ArrowEffect[Const[Unit], Const[Int]]

object Ask:
  def get: Int < Ask =
    ArrowEffect.suspend[Any](Tag[Ask], ())

  def run[A, S](n: Int)(v: A < (Ask & S)): A < S =
    ArrowEffect.handleCont(Tag[Ask], v)([C] => (_, cont) => cont(n))
end Ask

val question: Int < Ask = Ask.get.map(_ + 1)

val answered: Int < Any = Ask.run(41)(question)

@main def main(): Unit =
  assert(answered.eval == 42)
