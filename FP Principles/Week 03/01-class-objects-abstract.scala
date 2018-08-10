/**
abstract class, object, inheritance, recurrsion
function purity
*/

//Binary Tree (Integer Set)

abstract class IntSet {
  def contains (x: Int): Boolean
  def include (x: Int): IntSet
}

//Singleton Object - cannot have parameters as constructor and wouldnt use new for creating instance
object Empty extends IntSet {
  def contains (x: Int): Boolean = false
  def include (x: Int): IntSet = new NonEmpty (x, Empty, Empty)
  
  override def toString = "."   
}

class NonEmpty (element: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains (x: Int): Boolean = 
    if (x < element) left contains x
    else if (x > element) right contains x
    else true
  
  def include (x: Int): IntSet =
    if (x < element) new NonEmpty (element, left include x, right)
    else if (x > element) new NonEmpty (element, left, right include x)
    else this
    
    override def toString = "{" + left + element + right + "}" 
}

val set = new NonEmpty (7, Empty, Empty)
val set2 = set include 2
val set3 = set2 include 8
val set4 = set3 include 3 include 4 
//set3 include 3 woudl result into an object with no rechable reference - 
// include 4 method invocation happens though "dynamic binding" i.e. the method is invoed based on runtime object created
println (set)
println (set2)
println (set3)
println (set4)


/**
include 2 in set
  if 2 < element in set
    2 belongs to left -> you can reuse right as it is but start building left again including the root node itself...
  else if 2 > element in set
    2 belongs to right -> you can reuse left as it is but start building right again including the root node itself...
  else
    this

1) Create first root node with 7 - call it set
    -------
    |  7  |
  | ------- |
  E         E

2) include 2 in set and call it set2 (you can reassign it to set if set is var in which case the original Empty object with 7 becomes orphan)
    2 < 7 then 2 belongs to left of set - reuse the right i.e. E
    create new node with 7 as element, left (E) include 2, reuse right
                set2              set
                -------         -------
                |  7  |         |  7  |
              | ------- |     | ------- |
              |         E     E         E
        -------
        |  2  |
      | ------- |
      E         E
3) include 8 in set2 and call it set3
                set3                           set2              set
                -------                        -------         -------
                |  7  |                        |  7  |         |  7  |
              | ------- |                    | ------- |     | ------- |
              |         |                    |         E     E         E
        -------         -------        -------
        |  2  |         |  8  |        |  2  |
      | ------- |     | ------- |    | ------- |
      E         E     E         E    E         E

4) include 3 and then include 4 and call it set4
                set3                                     set3                           set2              set
                -------                                  -------                        -------         -------
                |  7  |                                  |  7  |                        |  7  |         |  7  |
              | ------------------|                    | ------- |                    | ------- |     | ------- |
              |                   |                    |         |                    |         E     E         E
        -------                   -------        -------         -------        -------
        |  2  |                   |  8  |        |  2  |         |  8  |        |  2  |
       |-------|                 |-------|     | ------- |     | ------- |    | ------- |
       E       |------           E       E     E         E     E         E    E         E
               |  3  |        
               |-------|      
               E       |------ 
                       |  4  | 
                      |-------|
                      E       E

*/









