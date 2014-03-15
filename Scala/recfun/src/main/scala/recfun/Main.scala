package recfun
import common._
import java.util

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if ( c == r || c == 0) return 1
    if ( c > r || c < 1 || r < 0 ) return 0
    pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: util.List[Char]): Boolean = {
    def balanceWithCount(chars: util.List[Char], stack: Int): Boolean = {
      if (chars.isEmpty)
        return true
      if (chars.get(0) == '(')
        return balanceWithCount(chars.subList(1, chars.size()), stack + 1)
      if (chars.get(0) == ')'){
        if (stack > 0)
          return balanceWithCount(chars.subList(1, chars.size()), stack - 1)
        return false
      }
      balanceWithCount(chars.subList(1, chars.size()), stack)
    }

    balanceWithCount(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: util.List[Int]): Int = ???
}
