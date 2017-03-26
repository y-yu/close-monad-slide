object Close {
  def apply[R, A](res: R, a: => A) = new Close[R, A](res) {
    def process()(implicit closer: Closer[R]): A = a
  }

  def apply[R](res: R): Close[R, R] = apply(res, res)
}
