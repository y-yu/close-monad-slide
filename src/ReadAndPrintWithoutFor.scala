def echo(msg: String): IO[Unit] =
  IO( println(msg) )

def readInt: IO[Int] =
  IO( StdIn.readLine().toInt )

def readAndPrint: IO[Unit] =
  echo("Enter a number:").flatMap { _ =>
    readInt.fltaMap { n =>
      echo(s"The input is $n").map {
        ()
      }
    }
  }

readAndPrint.run()
