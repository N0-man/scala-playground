/* Infix Notation
a.add(b) == a add b

In scala an identifier can start with symbol or can have only symbols

if you want to define a unary operation e.g. negation as comapre to post-fix then we use unary_ prefix for the function def
*/

class Rational (x: Int, y: Int) {	
	def numerator = x
	def denominator = y
	//Addition
	def add (that: Rational) = //this
		new Rational (this.numerator*that.denominator + this.denominator*that.numerator , this.denominator*that.denominator)
	
	def + (that: Rational) = //this
		new Rational (this.numerator*that.denominator + this.denominator*that.numerator , this.denominator*that.denominator)
	//Less
	def less (that: Rational) =
				this.numerator*this.denominator < that.numerator*that.denominator
	def < (that: Rational) =
			this.numerator*this.denominator < that.numerator*that.denominator
	//Negation
	def neg: Rational = new Rational (-numerator, denominator)
	def unary_- : Rational = new Rational (-numerator, denominator)
	def unary_! : Rational = new Rational (-numerator, denominator)
	
	override def toString = numerator + "/" + denominator
}

val a = new Rational (5,12)
val b  = new Rational (5,16)

println (a add b)
println (a + b)
println (a less b)
println (a < b)
println (a.neg)
println (-a)
println (!a)

/**
Specs:
- Any method which takes a single parameter can be used as an infix operator: a.m(b) can be written a m b.
- Any method which does not require a parameter can be used as a postfix operator: a.m can be written a m.
- Postfix operators have lower precedence than infix operators, so foo bar baz means foo.bar(baz) while foo bar baz bam means (foo.bar(baz)).bam and foo bar baz bam bim means (foo.bar(baz)).bam(bim).
- Also given a parameterless method m of object a, a.m.m is valid but a m m is not as it would parse as exp1 op exp2








