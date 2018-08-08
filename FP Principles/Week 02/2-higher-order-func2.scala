/*
sum function adds values evaluated by func from a to b
*/

def sum (func: Int => Int, a: Int, b: Int): Int =
	if (a>b) 0
	else func(a) + sum(func, a + 1, b)
	
def identity (x: Int) = x
def cube (x: Int) = x * x * x
def fact (x: Int): Int = if (x == 0) 1 else x * fact (x - 1)
	
def sumInts (a: Int, b: Int) = sum (identity, a, b)
def sumCubes (a: Int, b: Int) = sum (cube, a, b)
def sumFactorials (a: Int, b: Int) = sum (fact, a, b)

println (s"Sum of Ints ${sumInts(1,3)}")
println (s"Sum of Cubes ${sumCubes(1,3)}")
println (s"Sum of Factorials ${sumFactorials(1,3)}")
