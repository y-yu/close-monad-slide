def echo(msg: String): IO[Unit] =
  IO( println(msg) )

def readInt: IO[Int] =
  IO( StdIn.readLine().toInt )

def readAndPrint: IO[Unit] =
  for {
    _ <- echo("Enter a number:")
    n <- readInt
    _ <- echo(s"The input is $n")
  } yield ()

readAndPrint.run()
