import java.util
import scala.collection.JavaConverters._

/**
 * Created by tro2102 on 3/14/14.
 */
def main() {
  println("Balanced Parens?")
  val testString = "()"
  println(testString + ": " + balance(testString.toList.asJava))
  val testString1 = "blah()()()()"
  println(testString1 + ": " + balance(testString1.toList.asJava))
}

/**
 * Exercise 1
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
main()




































