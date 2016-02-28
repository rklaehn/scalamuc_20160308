package scalamuc

import spire.implicits._

object Demo7 extends App {

  val sumOfOptions =
    Option(1) + Option(2)

  val sumOfIndexedSeqs =
    IndexedSeq(1,2,3) + IndexedSeq(4,5,6)

  val productOfIndexedSeqAndScalar =
    IndexedSeq(1.0,2.0,3.0) :* 4.0

  val sumOfArrays =
    Array(1.0, 2.0, 3.0) + Array(4.0, 5.0, 6.0)
}