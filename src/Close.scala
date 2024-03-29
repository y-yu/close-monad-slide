abstract class Close[+R, +A](res: R) { self =>
  protected def process()(implicit closer: Closer[R]): A

  def run()(implicit closer: Closer[R]): A =
    try {
      process()
    } finally {
      closer.close(res)
    }

  def flatMap[AR >: R, B](f: A => Close[AR, B]): Close[AR, B] =
    new Close[AR, B](res) {
      def process()(implicit closer: Closer[AR]): B =
        try {
          f(self.process()).process()
        } finally {
          closer.close(res)
        }

      override def run()(implicit closer: Closer[AR]): B =
        process()
    }

  def map[B](f: A => B): Close[R, B] =
    flatMap(x => Close(res, f(x)))
}
