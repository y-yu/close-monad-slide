class TestCloser[A] extends Closer[A] {
  val closeOrder: scala.collection.mutable.ArrayBuffer[A] =
    scala.collection.mutable.ArrayBuffer.empty[A]

  def close(r: A): Unit = closeOrder.synchronized {
    closeOrder += r
  }
}
