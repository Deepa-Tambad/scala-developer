package assignments

import scala.util.control.Breaks
case class LinkedListImplementation[T]() {
  var head: Node[T] = null;

  // **************INSERTION**************
  def insertion(data:T): Unit = {
    val new_node: Node[T] = Node(data,null)
    new_node.next = null
    if (head == null) {
      head = new_node
    } else {
      var last: Node[T] =head
      while (last.next != null) last = last.next
      last.next = new_node
    }
  }

  // **************SEARCHING**************
  def searching(key: Int): Unit = {
    var currNode: Node[T] = head
    var prev:Node[T] = null
    while (currNode != null && currNode.data != key) {
      prev = currNode
      currNode = currNode.next
    }
    if (currNode != null) {
      println(key + " --> Element is found")
    }
    if (currNode == null) {
      println(key + " --> Element is not found")
    }
  }

  // **************DELETION BY KEY**************
  def deletingByKey(key: Int): Unit = {
    var currNode: Node[T] = head
    var prev: Node[T] = null
    if (currNode != null && currNode.data == key) {
      head = currNode.next
      println(key + " --> is deleted element")
    }
    while (currNode != null && currNode.data != key) {
      prev = currNode
      currNode = currNode.next
    }
    if (currNode != null) {
      prev.next = currNode.next
      println(key + " --> This element is  deleted")
    }
    if (currNode == null) {
      println(key + " --> is not found in list")
    }
  }

  // **************TRAVERSING**************
  def traversing(): Unit = {
    var currNode: Node[T]= head
    System.out.print("\nLinkedList: ")
    while (currNode != null) {
      System.out.print(currNode.data + " ")
      currNode = currNode.next
    }
    println("\n")
  }
}

sealed case class Node[T](var data: T, var next: Node[T]) {
  def getData: T = this.data
  def getNext: Node[T] = this.next;
  def printList(): Unit = {
    print(data)

    if (next != null) {
      print(",")
      next.printList();
    }
  }
}
