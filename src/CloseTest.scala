implicit def closeMonadInstance[R, A](implicit r: Gen[R]) =
  new Monad[({type L[B] = Close[R, B]})#L] {
    def point[B](a: => B): Close[R, B] =
      Close[R, B](r.sample(), a)
    def bind[B, C]
      (a: Close[R, B])(f: B => Close[R, C]): Close[R, C] =
      a.flatMap(f)
  }
 
implicit val closer: Closer[TestCloseable] =
  new TestCloser[TestCloseable]
 
type TestCloseableClose[A] = Close[TestCloseable, A]

val closeMonadTest = Properties.list(
  scalazlaws.monad.all[TestCloseableClose]
)
