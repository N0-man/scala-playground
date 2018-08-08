/*
Functional languages treat functions as first-class values. 
Functions that take other functions as parameters or that return functions as results are called 
Higher Order Functions. 
First order function are the one that acts on data types VS Higher order functions works on 
Functions as parameters…
*/

def add (a: Int, b: Int) = a+b
def sub (a: Int, b: Int) = a-b
def addAndMultiplyByTwo (a: Int, b: Int) = (a+b)*2
def sqAfterOperation (operation: (Int, Int) => Int, a: Int, b: Int): Int = {
  operation(a,b) * operation(a,b)
}

println(sqAfterOperation(add, 1,2))
println(sqAfterOperation(sub, 4,2))
println(sqAfterOperation(addAndMultiplyByTwo, 2,2))