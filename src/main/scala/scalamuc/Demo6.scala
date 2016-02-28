package scalamuc

import java.math.BigInteger

import org.apache.commons.math3.fraction.BigFraction
import spire.implicits._
import spire.math.{SafeLong, Rational}

/**
  * Integer performance comparison
  */
object Demo6 extends App {

  val spires = (1 until 100000).map(x => SafeLong(x))
  val bigIntegers = (1 until 100000).map(x => BigInteger.valueOf(x))

  def sumSafeLong = {
    var i = 0
    var result = Rational.zero
    while(i < spires.length) {
      result += spires(i)
      i += 1
    }
    result.toLong
  }

  def sumBigInteger = {
    var i = 0
    var result = BigFraction.ZERO
    while(i < bigIntegers.length) {
      result = result.add(bigIntegers(i))
      i += 1
    }
    result.longValue()
  }

  val th = ichi.bench.Thyme.warmed(verbose = println)
  th.pbenchOffWarm("spire SafeLong vs. java.math.BigInteger")(th.Warm(sumSafeLong))(th.Warm(sumBigInteger))
}