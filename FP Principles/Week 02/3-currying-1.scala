/*
Note in earlier Anonymus func example - parameter a and b are so DRY
we can eliminate them using currying (function returing funciton)
currying is a type of Higher-order function
*/

//Accept a Function and returns a function sumF
def sum (func: Int => Int): (Int, Int) => Int = {
	def sumF (a: Int, b: Int): Int =
		if (a > b) 0
		else func (a) + sumF (a+1, b)
	sumF //return function sumF
}

def fact (x: Int): Int = if (x == 0) 1 else x * fact (x - 1)
	
def sumInts = sum ((x: Int) => x) //Infers accepting a and b from sum
def sumCubes = sum (x => x*x*x)

println (s"Sum of Ints ${sumInts(1,3)}")
println (s"Sum of Cubes ${sumCubes(1,3)}")
println (s"Sum of Factorials ${sum (fact) (1,3)}") //call sum directly without middle func

/* 
Note Funciton applicaiton associates to Left
sum (fact) (1,3) == (sum (fact)) (1,3) -> first sum (fact) would evaluate and then would be applied to (1,3)
*/
