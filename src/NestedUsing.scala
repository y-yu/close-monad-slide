Using(new FileInputStream("source.txt"))) { in =>
  Using(new InputStreamReader(in, "UTF-8")) { reader =>
    Using(new BufferedReader(reader)) { buff =>
      Using(new FileOutputStream("dest.txt")) { out =>
        Using(new OutputStreamWriter(out, "UTF-8")) { writer =>
          var line = buff.readLine()
          while (line != null) {
            writer.write(line + "\n")
            line = buff.readLine()
          }
        }
      }
    }
  }
}
