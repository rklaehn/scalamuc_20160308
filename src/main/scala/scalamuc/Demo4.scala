package scalamuc

import spire.implicits._
import spire.math.Rational

/**
  * Demos rationals
  */
object Demo4 extends App {

  val a = Rational(1, 2) // normal creation of rational
  val b = r"1/2" // string interpolation based syntax. Typesafe and useful for rationals with very large numerators or denominators
  val c = a * b
  println(c)
}