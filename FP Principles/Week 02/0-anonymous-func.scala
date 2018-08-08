/*
An anonymous function 
	(x1 : T1, ..., xn : Tn) ⇒ E 
Where x = parameter identifier, T = parameter type, E = expression
can always be expressed using def as follows:

	def f(x1 : T1,...,xn : Tn) = E
where f is an arbitrary fresh name
*/

def sum (func: Int => Int, a: Int, b: Int): Int =
	if (a>b) 0
	else func(a) + sum(func, a + 1, b)
	
def fact (x: Int): Int = if (x == 0) 1 else x * fact (x - 1)
	
def sumInts (a: Int, b: Int) = sum ((x: Int) => x, a, b) //explicite type
def sumCubes (a: Int, b: Int) = sum (x => x*x*x, a, b) //type infered
def sumFactorials (a: Int, b: Int) = sum (fact, a, b) //you can do recursive anonymus funcs using Y combinators... we will see that later

println (s"Sum of Ints ${sumInts(1,3)}")
println (s"Sum of Cubes ${sumCubes(1,3)}")
println (s"Sum of Factorials ${sumFactorials(1,3)}")
