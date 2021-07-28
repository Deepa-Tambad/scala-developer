package assignments
class BinaryTree {
  var left=null
  var right = null

  /*------INSERTION-----------*/
  var root: Node2 = null
  def insertion(key: Int): Unit = {
    root = insert_Recursive(root, key)


    def insert_Recursive(node: Node2, key: Int): Unit = {
      if (root == null) {
        root = new Node2(key)
        root
      }
      if (key < root.key)
        root.left = insert_Recursive(root.left, key)
      else if (key > root.key)
        root.right = insert_Recursive(root.right, key)
      root
    }
  }

  /*------DELETION-------------*/

  def deletionKey(key: Int): Unit = {
    root = delete_Recursive(root, key)
    println(key + " is Deleted in Tree")


    def delete_Recursive(root: Node2, key: Int): Unit = {
      if (root == null)
        root
      if (key < root.key)
        root.left = delete_Recursive(root.left, key)
      else if (key > root.key)
        root.right = delete_Recursive(root.right, key)
      else {
        if (root.left == null)
          root.right
        else if (root.right == null) root.left
        root.key = minValue(root.right)
        root.right = delete_Recursive(root.right, root.key)
      }
      root
    }
  }

  /*-----------------SEARCHING--------------*/
  def searching(key: Int): Boolean = {
    root = search_Recursive(root, key)
    if (root != null)
      true
    else
      false


    def search_Recursive(root: Node2, key: Int): Node2 = {
      if (root == null || root.key == key)
        root
      if (root.key > key)
        search_Recursive(root.left, key)
      search_Recursive(root.right, key)
    }

  }
  def preOrder(): Unit = {
    println("Preorder Traversing:")
    preOrder_Recursive(root)

    def preOrder_Recursive(root: Node2): Unit = {
      if (root != null) {
        System.out.print(" " + root.key)
        preOrder_Recursive(root.left)
        preOrder_Recursive(root.right)
      }
    }
  }
  def inOrder(): Unit = {
    println("Inorder Traversing:")
    inorder_Recursive(root)

    def inorder_Recursive(root: Node2): Unit = {
      if (root != null) {
        inorder_Recursive(root.left)
        System.out.print(root.key + " ")
        inorder_Recursive(root.right)
      }
    }
  }
  def postOrder(): Unit = {
    println("Preorder Traversing:")
    postOrder_Recursive(root)

    def postOrder_Recursive(root: Node2): Unit = {
      if (root != null) {
        postOrder_Recursive(root.left)
        postOrder_Recursive(root.right)
        System.out.print(" " + root.key)
      }
    }
  }
  def minValue(node: Node2): Int = {
    var minval: Int = root.key
    while (root.left != null) {
      minval = root.left.key
      root = root.left
    }
    minval
  }
}
class Node2(var key: Int) {

  var left: Node2 = null
  var right = null

}
