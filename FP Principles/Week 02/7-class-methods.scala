/*
class with methods
Note: you can use def to define an immutable symbol (value) e.g. of def as value
def numerator or def numerator: Int
*/

//Requirements
//1) Add neg (negate numerator)
//2) Add Sub (subtraction)

class Rational (x: Int, y: Int) {
	def numerator = x
	def denominator = y
	
	def add (that: Rational) =
		new Rational (numerator*that.denominator + denominator*that.numerator , denominator*that.denominator)
	
	def neg: Rational = new Rational (-numerator, denominator)
	
	def sub (that: Rational) = add (that.neg)
	
	override def toString = numerator + "/" + denominator

}

val a = new Rational (5, 16)
val b = new Rational (5, 12)

println ("Addition : "+ a.add(b))
println ("Negative : "+ a.neg)
println ("Subtraction : "+ a.sub(b))
println ("Sub then Add : "+ a.sub(b).add(b))








