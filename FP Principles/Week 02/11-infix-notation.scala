/* Infix Notation
a.add(b) == a add b

In scala an identifier can start with symbol or can have only symbols

if you want to define a unary operation e.g. negation as comapre to post-fix then we use unary_ prefix for the function def
*/

class Rational (x: Int, y: Int) {	
	def numerator = x
	def denominator = y
	
	def add (that: Rational) = //this
		new Rational (this.numerator*that.denominator + this.denominator*that.numerator , this.denominator*that.denominator)
	
	def + (that: Rational) = //this
		new Rational (this.numerator*that.denominator + this.denominator*that.numerator , this.denominator*that.denominator)
	
	def less (that: Rational) =
				this.numerator*this.denominator < that.numerator*that.denominator
	def < (that: Rational) =
			this.numerator*this.denominator < that.numerator*that.denominator
			
	def neg: Rational = new Rational (-numerator, denominator)
	def unary_- : Rational = new Rational (-numerator, denominator)
	
	override def toString = numerator + "/" + denominator

}

val a = new Rational (5,12)
val b = new Rational (5,16)

println (a add b)
println (a + b)
println (a less b)
println (a < b)
println (a.neg)
println (-a)








