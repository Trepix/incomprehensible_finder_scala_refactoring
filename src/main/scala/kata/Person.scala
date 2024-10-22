package kata

import java.util.Date

case class Person(name: String, birthDate: Date) {

  def getName(): String = name

  def getBirthDate(): Date = birthDate

}

object Person {
  def create(name: String, birthDate: Date) = {
    val p = Person(name, birthDate)
    p
  }
}