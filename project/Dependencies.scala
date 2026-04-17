import sbt.*
import sbt.Keys.*

object Dependencies {
  val Version = new Object {
    val kyo = "1.0-RC1"

  }

  val core = Seq(
    "io.getkyo" %% "kyo-core" % Version.kyo
  )

}
