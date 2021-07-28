package assignments

object Main {
  def main(args:Array[String]) {
    println("-----------Stack---------------")
    var stk = new StackImplementation[Int];
    stk.pushImp(12);
    stk.pushImp(13);
    stk.pushImp(14);
    stk.traverseImp();
    stk.popImp();
    stk.traverseImp();
    stk.popImp();



    println("--------List-----------")
    var list = new LinkedListImplementation[Int]();

    list.insertion( 1)
    list.insertion( 2)
    list.insertion( 3)
    list.insertion( 4)
    list.insertion( 5)
    list.insertion( 6)
    list.insertion( 7)
    list.insertion( 8)
    println("----------------")
    list.searching(1)
    list.searching(86)
    println("----------------")
    list.traversing()
    list.deletingByKey(10)
    list.deletingByKey( 5)
    list.traversing()

    println("--------Queue---------")

    var que=new QueueImplementation[Int]()
    que.enQueue(1)
    que.enQueue(11)
    que.enQueue(12)
    que.traverseQue()
    que.deQueue()
    que.traverseQue()
    que.deQueue()

    println("---------BinaryTree------------")
    var bst = new BinaryTree
    var t=new Node2(5)
    bst.insertion(45)
    bst.insertion( 10)
    bst.insertion( 7)
    bst.insertion(12)
    bst.insertion(90)
    bst.insertion( 50)
    bst.deletionKey(12)
    val a=bst.preOrder()
    println(a)
    val b=bst.inOrder()
    println(b)
    val c=bst.postOrder()
    println(c)

    bst.deletionKey(12)
    val d=bst.inOrder()
    println()
    var ret_val: Boolean = bst.searching(50)
    println("\nKey is found in BST :"+ret_val);

    println("---------HashTable------------")

    val hs=new HashTableImp[Int,String](Vector.empty)
    val a=hs.insert(15,"SS")
    val b=a.insert(22,"AA")
    hs.getKey(2)
    hs.indexKey(1)
    hs.removeKey(2)

  }
}
