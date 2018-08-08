/*
 Multiple constrcutor can be defined using "this"
*/

class Rational (x: Int, y: Int) {
	def this(x: Int) = this(x,1) //another constructor using this
	
	def numerator = x
	def denominator = y
	
	def add (that: Rational) = //this
		new Rational (this.numerator*that.denominator + this.denominator*that.numerator , this.denominator*that.denominator)
	
	override def toString = numerator + "/" + denominator

}

val a = new Rational (5)

println (a)








