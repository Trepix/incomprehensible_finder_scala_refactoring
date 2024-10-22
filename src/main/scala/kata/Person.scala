package kata

import java.util.Date

case class Person(name: String, birthDate: Date) {
  def timeBetweenBirthdays(other: Person): Long = Math.abs(this.birthDate.getTime - other.birthDate.getTime)
}

object Person {
  val orderingByBirthDate: Ordering[Person] = Ordering.by(p => p.birthDate)
}