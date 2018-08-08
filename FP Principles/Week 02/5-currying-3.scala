/*
1) Write a product function that calculates the product of the values of a function for the points on a given interval.
2) Write factorial in terms of product

fact(5) = 
							120					60					20					5
multiply (1, multiply(2, multiply(3, multiply(4, multiply(5,1)))))

*/

def mapReduce (f: Int => Int, multiply: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
	if (a > b) zero
	else multiply (f(a), mapReduce(f, multiply, zero)(a+1, b))

def product (f: Int => Int) (a: Int, b: Int): Int =
	mapReduce (f, (x,y)=>x*y, 1)(a,b)
	
def fact(n: Int) = product (x=>x)(1,n)

println (s"Factorial: ${fact(5)}")

