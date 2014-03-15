package recfun

import org.scalatest.FunSuite

import scala.collection.JavaConverters._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {
  import Main.balance

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList.asJava))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList.asJava))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!balance(":-)".toList.asJava))
  }

  test("balance: counting is not enough") {
    assert(!balance("())(".toList.asJava))
  }

  test("balance: simple") {
    assert(balance("()".toList.asJava))
  }

  test("balance: repeat") {
    assert(balance("()()()()()".toList.asJava))
  }
}
