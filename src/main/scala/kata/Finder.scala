package kata

class Finder(private val persons: List[Person]) {

  def find(ft: Criteria): Option[Result] = {

    persons match {
      case Nil | _ :: Nil => None
      case _ =>
        implicit val personOrdering: Ordering[Person] = Person.orderingByBirthDate
        val list = persons.sorted
        val answer = ft match {
          case Criteria.Closest =>
            Result.apply _ tupled list
              .zip(list.tail)
              .map { case (p1, p2) => (p1, p2) }
              .minBy {
                (p1, p2) => p1.timeBetweenBirthdays(p2)
              }
          case Criteria.Furthest => Result(list.head, list.last)
        }
        Some(answer)
    }

  }
}