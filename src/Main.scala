implicit def closer[R <: Closeable]: Closer[R] =
  Closer(_.close())

(for {
  in     <- Close(new FileInputStream("source.txt"))
  reader <- Close(new InputStreamReader(in, "UTF-8"))
  buff   <- Close(new BufferedReader(reader))
  out    <- Close(new FileOutputStream("dest.txt"))
  writer <- Close(new OutputStreamWriter(out, "UTF-8"))
} yield {
  var line = buff.readLine()
  while (line != null) {
    writer.write(line + "\n")
    line = buff.readLine()
  }
}).run()
