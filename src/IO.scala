sealed trait IO[A] {
  def run(): A

  def flatMap[B](f: A => IO[B]): IO[B] =
    f(run())

  def map[B](f: A => B): IO[B] =
    flatMap(a => IO(f(a)))
}

object IO {
  def apply[A](a: => A): IO[A] =
    new IO[A] { def run(): A = a }
}
