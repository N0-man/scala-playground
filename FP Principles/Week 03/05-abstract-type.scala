/**
type alias is use as shorthand
**/

//type is use to represent (alias) a func with T as in put and T as output
type simpleFunc [T] = T => T

def eval[T] (f: simpleFunc[T], value: T) = f (value)

def identity (x: Int): Int = x
def square (x: Int) = x * x  //return type infered
def cube (x: Int) = x * x * x
def duplicate (x: String) = x + x

//T for eval is infered from 4, T for simpleFunc was infered from identity
println (eval (identity, 4)) 
println (eval (square, 4))
println (eval (cube, 4))
println (eval (duplicate, "Bla"))

/**
type can also be used for abstract members 
*/
trait Abstract {
  type T
  def transform (x: T): T
  val initial: T
  var current: T
}

//default value for constructor
class StringConcrete (val initial: String = "hello") extends Abstract {
  type T = String
  def transform (x: String) = x + x
  var current = initial
}

class IntConcrete extends Abstract {
  type T = Int
  def transform (x: Int) = x + x
  val initial = 1
  var current = initial
}

//type with anonymus functions
//Given a singleton set that can never be displayed fully but can only identify if an element is contained within it via contains method...
type Set = Int => Boolean //declare a functor that accepts an integer and return a boolean
def contains(s: Set, elem: Int): Boolean = s(elem)

def singletonSet(elem: Int): Set = (x: Int) => x == elem //funciton evaluation represents the set
def union(s: Set, t: Set): Set = x => s(x) || t(x) //infer x as Int from Set return type

val s1 = singletonSet(2) // this would hold a function as (x: Int) => x == 2
val s2 = singletonSet(4) // this would hold a function as (x: Int) => x == 4
val s3 = union(s1, s2) // this would be (x: Int) => (x => x == 2) || (x => x == 4)
println (contains(s1, 1)) // evaluated as s(elem) --> s(1) --> (1) => 1 == 2
println (contains(s3, 4))









