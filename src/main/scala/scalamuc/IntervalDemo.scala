package scalamuc

import java.time.LocalDateTime

import spire.implicits._
import spire.math.Interval

object IntervalDemo extends App {

  val a = Interval(0, 10)
  println(a)
  println(a * 2)
  println(a + a)
  println(a * a)


}