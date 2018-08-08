/*
Syntatic Sugar
There is more concise syntax in Scala for Function returning function which can eliminate sumF
def in earlier example - called as Multiple Parameter List

def f(args1) = {def g(args2) = E; g} == def f(args1) (args2) = E

def f(args1)...(argsn−1)(argsn) = E == def f = (args1 ⇒ (args2 ⇒ ...(argsn ⇒ E)...))
This is called currying, named after Haskell Brooks Curry (1900-1982)
*/

def sum (func: Int => Int) (a: Int, b: Int): Int = {
		if (a > b) 0
		else func (a) + sum (func) (a+1, b)
}

def identity (x: Int) = x
def cube (x: Int) = x * x * x
def fact (x: Int): Int = if (x == 0) 1 else x * fact (x - 1)
	
println (s"Sum of Ints ${sum (identity)(1,3)}")
println (s"Sum of Cubes ${sum (cube) (1,3)}")
println (s"Sum of Factorials ${sum (fact) (1,3)}")

/*
CONFUSION: multiple parameter list can also be comma seperated and yet achieve the same result
benefit of currying could be an intermediate state - need to explore
*/

//same result without currying
def sum1 (func: Int => Int, a: Int, b: Int): Int = {
		if (a > b) 0
		else func (a) + sum1 (func, a+1, b)
}

def identity1 (x: Int) = x
def cube1 (x: Int) = x * x * x
def fact1 (x: Int): Int = if (x == 0) 1 else x * fact1 (x - 1)
	
println (s"Sum1 of Ints ${sum1 (identity1, 1,3)}")
println (s"Sum1 of Cubes ${sum1 (cube1, 1,3)}")
println (s"Sum1 of Factorials ${sum1 (fact1, 1,3)}")