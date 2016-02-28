package scalamuc

import spire.implicits._

object QBenchmarks extends App {

  val numbers = (0 until 1000).map(_.toDouble).toArray

  val th = ichi.bench.Thyme.warmed(verbose = println)
  th.pbenchOffWarm("spire qsum vs. scala sum")(th.Warm(numbers.qsum))(th.Warm(numbers.sum))

  th.pbenchOffWarm("spire qmax vs. scala max")(th.Warm(numbers.qmax))(th.Warm(numbers.max))

  th.pbenchOffWarm("spire qsorted vs. scala sorted")(th.Warm(numbers.qsorted))(th.Warm(numbers.sorted))
}