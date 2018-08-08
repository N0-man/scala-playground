/*
Validation / Exceptions / Requirements
Denominator should be non-zero

require is a predefine fucntion that takes condition - if false then return the message - throws IllegalArgumentException
assert is also predefine works similar to require - throws AssertionError

*/

class Rational (x: Int, y: Int) {
	require (y!=0, "denominator must be non-zero")
	def numerator = x / g
	def denominator = y / g
	
	private def gcd (a: Int, b: Int): Int = if (b==0) a else gcd (b, a%b)
	private val g = gcd (x, y) //find GCD for rational
	
	def add (that: Rational) = //this
		new Rational (this.numerator*that.denominator + this.denominator*that.numerator , this.denominator*that.denominator)
	
	def neg: Rational = new Rational (-numerator, denominator)
	
	def sub (that: Rational) = add (that.neg)
	
	override def toString = numerator + "/" + denominator

}

val a = new Rational (5, 16)
val b = new Rational (5, 0)

println ("Reduced Sub then Add : "+ a.sub(b).add(b))

/**
Notes:
def - evaluates everytime its called (lazy by default yet expensive)
val - evaluates just once irrespective of when it is called
lazy val - evaluates just once and only when called first time
*/








