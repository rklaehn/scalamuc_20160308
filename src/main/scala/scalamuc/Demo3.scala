package scalamuc

import spire.algebra.Field
import spire.implicits._

import scala.reflect.ClassTag
import scala.util.Random

/**
  * Doubles suck except for performance
  *
  * math stuff taken from http://mathworld.wolfram.com/GeometricSeries.html
  */
object Demo3 extends App {

  def geometricSeriesElements[@sp T: Field: ClassTag](q: T, n: Int): Array[T] =
    (0 until n).map(k => q ** k).toArray

  def geometricSeriesResult[@sp T: Field](q: T, n: Int): T =
    (1 - q ** (n + 1)) / (1 - q)

  val expected = geometricSeriesResult(0.5, 100)
  val elements = geometricSeriesElements(0.5, 100)
  val results = (0 until 100).map { n=>
    elements.qshuffled.qsum
  }
  println(results)
}