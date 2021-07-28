package assignments
case class QueueImplementation[T]()
{
  var front: QNode[T]=null
  var rear: QNode[T]=null
  def enQueue(data: T): Unit = {
    val queue: QNode[T] = QNode[T](data: T, null)
    if(rear == null) {
      rear=queue
      front = queue
    }
    rear.next= queue
    rear=queue
  }
  def deQueue(): Unit = {
    if (rear == null) {
      println("Queue is Empty")
    }
    var v: QNode[T] = front
    println("\n"+v.data+" is deleted in Queue")
    front = front.next
    if (front == null) {
      rear = null
    }
  }
  def traverseQue(): Unit = {
    var n:QNode[T]=front
    println("Queue Elements are :")
    while(n.next!= null) {
      print(n.data+" ");
      n=n.next
    }
    print(n.data+" ")
  }
}
sealed case class QNode[T](data: T, var next: QNode[T]) {
  def printList(): Unit = {
    print(data)
    if (next != null) {
      print(" ")
      next.printList()
    }
  }
}