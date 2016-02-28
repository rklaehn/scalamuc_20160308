package scalamuc

import org.scalacheck.Test
import org.typelevel.discipline._
import spire.algebra.Field
import spire.implicits._

object DoubleIsNotLawful extends App {

  val params = Test.Parameters.default.withMinSuccessfulTests(10000)
  implicit val nonZero = Predicate[Double](_ != 0.0)

  def checkDoubleAdditiveGroup() = {
    implicit val g = Field[Double].additive
    println("double additive group tests")
    spire.laws.GroupLaws[Double].abGroup.all.check(params)
  }

  def checkDoubleRing() = {
    println("double ring tests")
    spire.laws.RingLaws[Double].ring.all.check(params)
  }

  def checkRationalRing() = {
    import spire.math.Rational
    import spire.laws.arb._

    implicit val nonZero = Predicate[Rational](x => !x.isZero)

    println("rational ring tests")
    spire.laws.RingLaws[Rational].ring.all.check(params)
  }

  checkDoubleAdditiveGroup()
  checkDoubleRing()
  checkRationalRing()
}
