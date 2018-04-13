// This is a one liner comment
// I can also have multiple lines of comments

/* I can have a block of comment
   just like this.
   /* Oh also I can nest my blocks of comments.
      This is pretty cool I think.
    */
 */
import kotlin.math.*
fun main(args: Array<String>) {

  val fahrenheit: Double = 99.5
  println("$fahrenheit deg F = ${FToCTemp(fahrenheit)} deg C")

  val celsius: Double = 37.5
  println("$celsius deg F = ${CToFTemp(celsius)} deg C")

  chessboard()

  val angleDegrees: Double = 45.0
  println("$angleDegrees degrees = ${degToRad(angleDegrees)} radians")

  val x1: Double = 0.0
  val x2: Double = 0.0
  val y1: Double = 0.0
  val y2: Double = 5.0
  println("Distance between ($x1, $x2) and ($y1, $y2) = ${eucDist(x1, x2, y1, y2)}")
}

/* CHALLENGE 6
  Converts Fahrenheit to Celsius
*/
fun FToCTemp(fahrenheit: Double) : Double {
  return (fahrenheit - 32) / 1.8
}

/* Challenge 6
  Converts Celsius to Fahrenheit
*/
fun CToFTemp(celsius: Double) : Double {
  return celsius * 1.8 + 32
}


/* CHALLENGE 7
  Suppose the squares on a chessboard are numbered left to right,
  top to bottom, with 0 being the top-left square and 63 being the
  bottom-right square. Rows are numbered top to bottom, 0 to 7.
  Columns are numbered left to right, 0 to 7.
  Declare a constant position and assign it a value between 0 and 63.
  Calculate the corresponding row and column numbers and store the results
  in constants named row and column.
 */
fun chessboard() {
  val position: Int = 5
  val noOfRows = 8
  val noOfColumns = 8
  val column = position % noOfColumns
  val row = position / noOfRows
  println("Position $position is at (r:$row, c:$column)")
}


/* CHALLENGE 8
   Degrees to Radians
 */
fun degToRad(degrees: Double): Double {
  return degrees / 360 * (2 * PI)
}

/* CHALLENGE 9
   Euclidean distance between two points (x1, x2) and (y1, y2)
 */
fun eucDist(x1: Double, x2: Double, y1: Double, y2: Double): Double {
  return sqrt((y1 - x1).pow(2) +  (y2 - x2).pow(2))
}
