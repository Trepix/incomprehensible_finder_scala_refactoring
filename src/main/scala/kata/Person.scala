package kata

import java.util.Date

case class Person(name: String, birthDate: Date) {
  def isYoungerThan(other: Person) = this.birthDate.getTime <= other.birthDate.getTime
}

object Person {
  val orderingByBirthDate: Ordering[Person] = Ordering.by(p => p.birthDate)
}