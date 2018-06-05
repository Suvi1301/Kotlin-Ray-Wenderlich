import java.lang.Math.log
import java.lang.Math.pow
import kotlin.math.pow

fun main(args: Array<String>) {

  /* CHAPTER 4
    /* Boolean Logic Mini Exercise */
  */
  val myAge = 20
  val isTeenager = myAge < 20 && myAge > 12
  println("My age is a teenager?: $isTeenager")

  val theirAge = 30
  val bothTeenager = isTeenager && theirAge < 20 && theirAge > 12
  println("Both ages are teenager?: $bothTeenager")

  val reader = "Suvineet Singh"
  val author = "Ray Wenderlich"
  val authorIsReader = reader == author
  println("is the Author the Reader?: $authorIsReader")
  val readerBeforeAuthor = reader < author
  println("reader is before author?: $readerBeforeAuthor")

  // if-else example
  if (isTeenager)
    println("myAge is a teenager!")
  else
    println("myAge is NOT a teenager")

  val positionOnBoard = Pair(5,5)
  println("Next Position " + findNextPositionOnChessboard(positionOnBoard))

  quadraticSolution(1.0, 4.0, 3.0)

  val month = "february"
  val year = 2016
  println("$month, $year has " + daysInMonth(month, year) + " days")

  val a = 20
  println("$a is a power of a 2?: " + pow2(a))
  first10PowersOf2()
  println()
  val n = 7
  println("$n th Fibonacci Number is " + nthFib(n))

  val fact = 4
  println("$fact! = " + nFactorial(fact))

  val diceNumber = 2
  print("Odds of getting $diceNumber = " + diceOdds(diceNumber) + "%")
}

/* CHALLENGE 3
  Suppose the squares on a chessboard are numbered left to right, top to
  bottom, with 0 being the top-left square and 63 being the bottom-right
  square. Rows are numbered top to bottom, 0 to 7. Columns are numbered
  left to right, 0 to 7. Given a current position on the chessboard,
  expressed as a row and column number, calculate the next position on
  the chessboard, again expressed as a row and column number. The
  ordering is determined by the numbering from 0 to 63. The position
  after 63 is again 0.
 */
fun findNextPositionOnChessboard(pos: Pair<Int, Int>): Pair<Int, Int> {
  val row = pos.first
  val col = pos.second
  if (col < 7)
    return Pair(row, col + 1)
  else
    return Pair(row + 1, 0)
}

/* CHALLENGE 4
  Find roots of a quadratic given its coefficients a, b, c
 */
fun quadraticSolution(a: Double, b: Double, c: Double) {
  val discriminant = b.pow(2) - (4.0*a*c)
  if (discriminant < 0.0)
    println("No real roots")
  else if (discriminant == 0.0) {
    val root = b / 2*a
    println("Single root: $root")
  } else if (discriminant > 0.0) {
    val root1 = (b + Math.sqrt(discriminant)) / 2.0*a
    val root2 = (b - Math.sqrt(discriminant)) / 2.0*a
    println("Two Distinct roots: $root1 AND $root2")
  }
}

/* CHALLENGE 5
  Return days in Month given a month as string and year as Int
 */
fun daysInMonth(month: String, year: Int): Int {
  if (month == "january" || month == "march" || month == "may" ||
          month == "july" || month == "august" || month == "october" ||
          month == "december")
    return 31
  else if (month == "april" || month == "june" ||
          month == "september" || month == "november")
    return 30
  else if (month == "february") {
    if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
      return 29
    else
      return 28
  } else
    return -1
}

/* CHALLENGE 6
  Determine whether a number is a power of 2
 */
fun pow2(a: Int): Boolean {
  /* Non loop approach */
//  if (Math.log(a.toDouble()) % 1.0 == 0.0)
//    return true
//  return false
  var x = a.toDouble()
   do {
    if (x / 2.0 % 1.0 != 0.0)
      return false
    x /= 2.0
  } while (x >= 2.0)
  return true
}

/* CHALLENGE 7
  Print first 10 powers of 2
 */
fun first10PowersOf2() {
  var i = 0
  println("Fist 10 Powers of 2")
  while (i < 10) {
    print(2.0.pow(i).toInt())
    if (i < 9)
      print(" : ")
    i++
  }
}

/* CHALLENGE 8
  Find the nth Fibonacci Number
 */
fun nthFib(n: Int): Int {
  if (n < 2)
    return n
  var i = 2
  var prev = 1
  var fibNum = 1
  while (i < n) {
    var temp = fibNum
    fibNum += prev
    prev = temp
    i++
  }
  return fibNum
}

/* CHALLENGE 9
  n-Factorial
 */
fun nFactorial(n: Int) : Int {
  if (n == 0)
    return 1
  var i = 1
  var fact = n
  while (i < n) {
    fact *= (n - i)
    i++
  }
  return fact
}

/* CHALLENGE 10
  Given a number between 2 and 12, calculate the odds of rolling this
  number using two six-sided dice. Compute it by exhaustively looping
  through all of the combinations and counting the fraction of outcomes
  that give you that value. Don’t use a formula.
 */
fun diceOdds(n: Int) : Double {
  var i = 1
  var j = 1
  var matches = 0
  var total = 0
  while (i <= 6) {
    while (j <= 6) {
      if (j + i == n)
        matches++
      j++
      total++
    }
    i++
    j = 1
  }
  return matches*100 / total.toDouble()
}
