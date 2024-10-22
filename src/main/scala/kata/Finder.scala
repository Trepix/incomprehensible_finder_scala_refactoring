package kata

import scala.collection.JavaConverters.*

class Finder(private val _p: List[Person]) {

  def Find(ft: Criteria): Option[Result] = {

    if (_p.size <= 1) {
      return None
    }

    implicit val personOrdering: Ordering[Person] = Person.orderingByBirthDate
    val list = _p.toList.sorted
    val answer = ft match {
      case Criteria.Closest => {
        val x = list.zip(list.tail).map { case (p1, p2) => (p1, p2, p1.timeBetweenBirthdays(p2)) }.minBy {
          case (_, _, timeBetweenBirthdays) => timeBetweenBirthdays
        }
        Result(x._1, x._2)
      }
      case Criteria.Furthest => {
        Result(list.head, list.last)
      }
    }
    Some(answer)
  }
}