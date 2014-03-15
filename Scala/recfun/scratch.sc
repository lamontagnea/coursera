def countChange(money: Int, coins: List[Int]): Int = {
  println("Money: " + money + ", coins: " + coins)
  if (money == 0) return 1
  if (money < 0 || coins.isEmpty) return 0
  countChange(money, coins.slice(1, coins.size)) + countChange(money-coins.head, coins)
}
println(countChange(4,List(1,2)))






















println(countChange(300,List(5,10,20,50,100,200,500)))




































