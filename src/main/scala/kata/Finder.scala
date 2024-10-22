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

    if (_p.size <= 1) {
      return None
    }

    implicit val personOrdering: Ordering[Person] = Person.orderingByBirthDate
    val list = _p.asScala.toList.sorted
    val answer = ft match {
      case Criteria.Closest => {
        val x = list.zip(list.tail).map { case (p1, p2) => (p1, p2, p1.timeBetweenBirthdays(p2)) }.minBy {
          case (_, _, timeBetweenBirthdays) => timeBetweenBirthdays
        }
        val ir = InternalResult()
        ir.P1 = x._1
        ir.P2 = x._2
        ir
      }
      case Criteria.Furthest => {
        val ir = InternalResult()
        ir.P1 = list.head
        ir.P2 = list.last
        ir
      }
    }

    Some(Result(answer.P1, answer.P2))
  }
}
