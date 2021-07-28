package assignments

class HashTableImp[K,V](entries:Vector[Vector[Entry[K,V]]]){
  def insert(key: K, value: V): HashTableImp[K, V] ={
    val idx = indexKey(key)
    if(entries.isEmpty) {
      init.insert(key, value)
    } else {
      val chain = entries(idx)
      chain.indexWhere(_.key == key) match {
        case -1 => // key not found
          val e = Entry(key, value)
          new HashTableImp(entries.updated(idx, e +: chain))
        case i =>
          val replaced = chain(i).copy(value = value)
          new HashTableImp(entries.updated(idx, chain.updated(i, replaced)))
      }
    }
  }
  private val limit = 10
  private def init: HashTableImp[K, V] = {
    new HashTableImp(Vector.fill(limit)(Vector.empty))
  }
  def indexKey(key: K): Int = {
    key.hashCode() & entries.length
  }
  def removeKey(key: K): HashTableImp[K, V] = {
    val idx = indexKey(key)
    val updated = entries.updated(idx, entries(idx).filter(_.key != key))
    new HashTableImp(updated)
  }
  def getKey(key: K): Unit = {
    val idx = indexKey(key)
    val a: Option[V] =entries(idx).find(_.key == key).map(_.value)
    println(a)
  }
}
case class Entry[K, V](key: K, value: V)