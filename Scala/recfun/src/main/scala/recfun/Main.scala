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
    if ( c > r || c < 0 || r < 0 ) 0
    else if ( c == r || c == 0) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceWithCount(chars: List[Char], stack: Int): Boolean = {
      if (chars.isEmpty)
        true
      else if (chars.head == '(')
        balanceWithCount(chars.slice(1, chars.size), stack + 1)
      else if (chars.head == ')'){
        if (stack > 0)
          balanceWithCount(chars.slice(1, chars.size), stack - 1)
        else false
      }
      else balanceWithCount(chars.slice(1, chars.size), stack)
    }

    balanceWithCount(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else countChange(money, coins.slice(1, coins.size)) + countChange(money-coins.head, coins)
  }
}
