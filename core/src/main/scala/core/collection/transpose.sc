Seq(1,2,3).transpose(t => Seq(t))

val result = Array((1,Array(1.0,0.0,5.2,0.0)), (1,Array(1.0,0.0,6.3,0.0)), (2,Array(0.0,1.0,0.0,1.2)), (2,Array(0.0,1.0,0.0,2.5)))

result.groupBy(_._1).mapValues(_.map(_._2).transpose.map(_.sum)).toArray