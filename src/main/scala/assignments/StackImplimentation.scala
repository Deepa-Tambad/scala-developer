package assignments
class StackImplementation[T] {
  var top :StkNode[T] = null

  def pushImp(data:T):Unit = {
    val newNode: StkNode[T] = StkNode(data,null)
    if(top==null){
      top=newNode
    }else{
      val tempNode = top
      top=newNode
      newNode.next=tempNode
    }
  }
  def popImp(): Unit ={
    if(top==null){
      println("Stack is Empty")
    }else{
      val topEle =top.data
      println(s"$topEle is Popped  ")
      top=top.next
      val newEle = top.data
      println(s" Top element  is $newEle ")
    }
  }
  def traverseImp(): Unit = {
    if (top != null) {
      top.printList()
    }
    println()
  }
}
case class StkNode[T](data:T, var next:StkNode[T]){
  def printList(): Unit = {
    print(data)
    if (next != null) {
      print(" ")
      next.printList()
    }
  }
}