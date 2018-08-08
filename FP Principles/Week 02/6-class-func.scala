/*
class with external functions
*/

class Rational (x: Int, y: Int) {
	def numerator = x
	def denominator = y
}

def addRationals (a: Rational, b: Rational) = {
	new Rational (a.numerator*b.denominator + a.denominator*b.numerator , a.denominator*b.denominator)
}

def displayRationalAsString(r: Rational) =
	s"${r.numerator} / ${r.denominator}"

val a = new Rational (5, 16)
val b = new Rational (5, 12)
println (s"a = ${displayRationalAsString(a)}")
println (s"b = ${displayRationalAsString(b)}")
println (s"Addition = ${displayRationalAsString(addRationals(a,b))}")


/*
A Rational is a fraction with a non-zero denominator

5/16 + 5/12 = ((5*12)+(5*16)) / 16 * 12 = 140/192 = 35/48

Another way is using LCM (least common multiple)
LCM for 16 and 12 = 48 i.e. 16*3 == 12*4 == 48
so multiply the multiples with the respective numerators 
(5*3)/48 + (5*4)/48 = (15+20)/48 = 35/48
*/