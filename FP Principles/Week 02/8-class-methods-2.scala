/*
Simplify the Rational numbers using GCD (greatest common divisor)
Modulo % = remainder of the euclidean division of one number by another
So 7 % 5 = 2.
5 % 7 = 5
3 % 7 = 3
2 % 7 = 2
1 % 7 = 1
*/

class Rational (x: Int, y: Int) {
	def numerator = x / g
	lazy val denominator = y / g
	
	private def gcd (a: Int, b: Int): Int = if (b==0) a else gcd (b, a%b)
	private val g = gcd (x, y) //find GCD for rational
	
	def add (that: Rational) = //this
		new Rational (this.numerator*that.denominator + this.denominator*that.numerator , this.denominator*that.denominator)
	
	def neg: Rational = new Rational (-numerator, denominator)
	
	def sub (that: Rational) = add (that.neg)
	
	override def toString = numerator + "/" + denominator

}

val a = new Rational (5, 16)
val b = new Rational (5, 12)

println ("Reduced Sub then Add : "+ a.sub(b).add(b))

/**
Notes:
def - evaluates everytime its called (lazy by default yet expensive)
val - evaluates just once irrespective of when it is called
lazy val - evaluates just once and only when called first time
*/








