val in     = new FileInputStream("source.txt")
val reader = new InputStreamReader(in, "UTF-8")
val buff   = new BufferedReader(reader)
val out    = new FileOutputStream("dest.txt")
val writer = new OutputStreamWriter(out, "UTF-8")

var line = buff.readLine()
while (line != null) {
  writer.write(line + "\n")
  line = buff.readLine()
}

writer.close()
out.close()
buff.close()
reader.close()
in.close()
