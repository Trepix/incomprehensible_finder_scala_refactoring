package kata

import kata.Criteria

import java.util
import java.util.ArrayList
import scala.collection.JavaConverters._

class Finder(private val _p: util.List[Person]) {

  class InternalResult {

    var P1: Person = _

    var P2: Person = _

    var D: Long = _
  }

  def Find(ft: Criteria): Option[Result] = {
    val tr = new ArrayList[InternalResult]()

    for (i <- 0 until _p.size - 1) {
        for (j <- i + 1 until _p.size) {
            val r: InternalResult = new InternalResult()

            if (_p.get(i).birthDate.getTime < _p.get(j).birthDate.getTime) {
                r.P1 = _p.get(i)
                r.P2 = _p.get(j)
            } else {
                r.P1 = _p.get(j)
                r.P2 = _p.get(i)
            }

            r.D = r.P2.birthDate.getTime - r.P1.birthDate.getTime
            tr.add(r)
        }
    }

    if (tr.size < 1) {
      return None
    }

    val answer = tr.asScala.reduce((r1, r2) =>  ft match {
      case Criteria.Closest => if (r1.D < r2.D) r1 else r2
      case Criteria.Furthest => if (r1.D > r2.D) r1 else r2
    })

    Some(Result(answer.P1, answer.P2))
  }
}
