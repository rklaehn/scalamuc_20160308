package scalamuc

import spire.implicits._
import spire.math.Rational
import org.apache.commons.math3.fraction.BigFraction

/**
  * Rational performance comparison
  */
object Demo5 extends App {

  val spireRats = (1 until 40).map(x => Rational(1, x))
  val commonFraction = (1 until 40).map(x => new BigFraction(1, x))

  def sumSpire = {
    var i = 0
    var result = Rational.zero
    while(i < spireRats.length) {
      result += spireRats(i)
      i += 1
    }
    result.toLong
  }

  def sumFraction = {
    var i = 0
    var result = BigFraction.ZERO
    while(i < commonFraction.length) {
      result = result.add(commonFraction(i))
      i += 1
    }
    result.longValue()
  }

  val th = ichi.bench.Thyme.warmed(verbose = println)
  th.pbenchOffWarm("spire Rational vs. org.apache.commons.math3.fraction.BigFractional")(th.Warm(sumSpire))(th.Warm(sumFraction))
}