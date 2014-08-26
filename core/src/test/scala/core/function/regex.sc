val str = "Point(123 456)"
val re = """Point\((\d+) (\d+)\)""".r

val re(f, s) = str
println((f, s))