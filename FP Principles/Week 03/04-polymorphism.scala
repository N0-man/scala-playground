/**
1) Implement List DataStructure
2) Find nth element of List
3) Throw out of bound error if n is less then 0 or greater than total elements
**/

//T is generic type
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

//A val constructor arguments also creates a value member of the class
//hence it automatically implements from List[T]
class Cons[T] (val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false  
  override def toString = "( " + head + " . " + tail + " )"   
}

/*Note: If we say val head instead of def then it would throw NoSuchElementException everytime new Nil is called
remember val is evaluated once but at the time of initialization... you could perhaps use "lazy val"
*/
class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
  override def toString = "nil"   
}

def nth[T] (n: Int, list: List[T]): T =
  if (list.isEmpty) throw new IndexOutOfBoundsException("Gone beyound")
  else if (n == 0) list.head
  else nth (n - 1, list.tail) //iterate n times, travel the tail i.e. tail of tail of tail n times - head would give the nth element
  
val intList = new Cons (2, new Cons (5, new Cons(1, new Nil)))
val stringList = new Cons ("Hello", new Cons ("Kiki", new Cons("Dance", new Nil)))
println (intList)
println (stringList)
println (nth(1, intList))
println (nth(1, stringList))
println (nth(-1, stringList)) //out of bound exception

//Note that there was no type that was passed with new Nil it was infered from the first parameter

/**
A "cons" is a fundamental function in most programming dialects - it means construct a memory cell with 2 elements
i.e. value and pointer to the next cell

----------      ----------
| 1 |  --|------| 2 |  --|---NIL
----------      ----------
Consider a List with 3 elements - it can be stated as 

(cons 2 (cons 5 (cons 1 nil)))
  or
(list 2 5 1)
  or
(2 . (5 . (1 . nil)))
  or
*--*--*--nil
|  |  |
2  5  1

*/









