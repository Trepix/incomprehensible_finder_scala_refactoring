package kata

import kata.Criteria

import java.util
import java.util.ArrayList
import scala.collection.JavaConverters._

class Finder(private val _p: util.List[Person]) {

  class InternalResult {

    var P1: Person = _

    var P2: Person = _

    def timeBetweenBirthday = P2.birthDate.getTime - P1.birthDate.getTime
  }

  def Find(ft: Criteria): Option[Result] = {
    val tr = new ArrayList[InternalResult]()

    for (i <- 0 until _p.size - 1) {
        for (j <- i + 1 until _p.size) {
            val r: InternalResult = new InternalResult()

            if (_p.get(i).isYoungerThan(_p.get(j))) {
                r.P1 = _p.get(i)
                r.P2 = _p.get(j)
            } else {
                r.P1 = _p.get(j)
                r.P2 = _p.get(i)
            }
            tr.add(r)
        }
    }

    if (tr.size < 1) {
      return None
    }

    val answer = tr.asScala.reduce((r1, r2) =>  ft match {
      case Criteria.Closest => if (r1.timeBetweenBirthday < r2.timeBetweenBirthday) r1 else r2
      case Criteria.Furthest => {
        implicit val personOrdering: Ordering[Person] = Person.orderingByBirthDate
        val list = _p.asScala.toList.sorted
        val ir = InternalResult()
        ir.P1 = list.head
        ir.P2 = list.last
        ir
      }
    })

    Some(Result(answer.P1, answer.P2))
  }
}
