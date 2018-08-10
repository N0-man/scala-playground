/**
Scala local type inference allows the programmer to omit certain types annotations 
*/

val x = 1 + 2 * 3         // the type of x is Int
val y = x.toString()      // the type of y is String
def succ(x: Int) = x + 1  // method succ returns Int values

//For recursive methods, the compiler is not able to infer a result type
def fac(n: Int):Int = if (n == 0) 1 else n * fac(n - 1)

/**
GENERICS (polymorphism)
Polymorphic Methods, Generic Class
*/
//It is also not compulsory to specify type parameters when polymorphic methods are called or generic classes are instantiated
case class MyPair[A, B](x: A, y: B);
object InferenceTest3{
  def id[T](x: T) = x
  val p = MyPair(1, "scala") // type: MyPair[Int, String]
  val q = id(1)              // type: Int
}

/**
val x: MyPair[Int, String] = MyPair[Int, String](1, "scala")
is equal to
val x = MyPair(1, "scala")
*/