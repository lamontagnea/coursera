package recfun

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
    if ( c > r || c < 0 || r < 0 ) return 0
    if ( c == r || c == 0) return 1
    pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceWithCount(chars: List[Char], stack: Int): Boolean = {
      if (chars.isEmpty)
        return true
      if (chars.head == '(')
        return balanceWithCount(chars.slice(1, chars.size), stack + 1)
      if (chars.head == ')'){
        if (stack > 0)
          return balanceWithCount(chars.slice(1, chars.size), stack - 1)
        return false
      }
      balanceWithCount(chars.slice(1, chars.size), stack)
    }

    balanceWithCount(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) return 1
    if (money < 0 || coins.isEmpty) return 0
    countChange(money, coins.slice(1, coins.size)) + countChange(money-coins.head, coins)
  }
}
