trait TestCloseable extends Closeable {
  val id: Int
  def close(): Unit = ()
}

class ConcreteTestCloseable1(val id: Int) extends TestCloseable
class ConcreteTestCloseable2(val id: Int) extends TestCloseable
