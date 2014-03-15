/**
 * Created by tro2102 on 3/14/14.
 */
def main() {
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
  if ( c == r ) return 1
  if ( c == 0) return 1
  pascal(c-1, r-1) + pascal(c, r-1)
}

main()















