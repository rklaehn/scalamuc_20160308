package scalamuc

import spire.implicits._
import spire.algebra.Field

/**
  * specialized generic numerical methods are exactly as fast as non-generic ones
  */
object Demo2 extends App {

  def sumAndAvg[@sp T: Field](elements: Array[T]): (T, T) = {
    var i = 0
    var sum = Field[T].zero
    while(i < elements.length) {
      sum += elements(i)
      i += 1
    }
    val avg = sum / elements.length
    (sum, avg)
  }

  def sumAndAvgDouble(elements: Array[Double]): (Double, Double) = {
    var i = 0
    var sum = 0.0
    while(i < elements.length) {
      sum += elements(i)
      i += 1
    }
    val avg = sum / elements.length
    (sum, avg)
  }

  val data = (0 until 1000).map(_.toDouble).toArray

  val th = ichi.bench.Thyme.warmed(verbose = println)
  th.pbenchOffWarm("primitive vs. generic")(th.Warm(sumAndAvg(data)))(th.Warm(sumAndAvgDouble(data)))
}
