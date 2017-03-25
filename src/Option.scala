sealed trait Option[+A] {
  def point(a: A): Option[A]
  def flatMap[B](f: A => Option[B]): Option[B]
  def map[B](f: A => B): Option[B] = flatMap(x => point(f(x)))
}

case class Some[+A](value: A) extends Option[A] {
  def point(a: A): Option[A] = Some(a)
  def flatMap[B](f: A => Option[B]): Option[B] = f(value)
}

case object None extends Option[Nothing] {
  def point(a: A): Option[A] = None
  def flatMap[B](f: A => Option[B]): Option[B] = None
}

