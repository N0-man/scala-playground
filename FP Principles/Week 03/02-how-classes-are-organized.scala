/**
Note: all members of package scala, java.lang, and scala.Predef are automaticlaly imported
also scala.Int, scala.Boolean, etc are auto imported
*/

import week3.Rational // imports just Rational
import week3.{Rational, Hello} // imports both Rational and Hello 
import week3._ // imports everything in package week3



- scala.Any - 
    base type of all types. 
    Methods: ‘==‘, ‘!=‘, ‘equals‘, ‘hashCode, ‘toString‘ 
- scala.AnyVal - 
    base type of all primitive types. (scala.Double, scala.Float, etc.)
- scala.AnyRef - 
    base type of all reference types. (alias of java.lang.Object, supertype of java.lang.String, scala.List, any user-defined class)
- scala.Null - 
    is a subtype of any scala.AnyRef (null is the only instance of type Null), and 
    
- scala.Nothing -
    Nothing is at the bottom of Scala’s type hierarchy. It is a subtype of every other type
      To signal abnormal termination
      As an element type of empty collections
- Null type -
    Null is a subtype of every class that inherits from Object
    it is incompatible with subtypes of AnyVal.
     val x = null         // x: Null
     val y: String = null // y: String
     val z: Int = null    // error: type mismatch

- When the return type mismatches then it is cast to super type
     if (true) 1 else false
     here the return when true is Int whereas for else its Boolean
     hence the return type would be AnyVal

//Traits are like interfaces in Java, but they can also contain concrete members, i.e. method implementations or field definitions.

//A class can inherit from one super class but many traits
class Square extends Shape with Planar with Movable ...

//Scala’s exception handling is similar to Java’s.
def error = throw new Error ("you are bombed")
error




