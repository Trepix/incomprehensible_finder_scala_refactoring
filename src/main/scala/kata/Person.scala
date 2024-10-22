package kata

import java.util.Date

class Person {

  var name: String = _

  var birthDate: Date = _

  def getName(): String = name

  def getBirthDate(): Date = birthDate

}

object Person {
  def create(name: String, birthDate: Date) = {
    val p = Person()
    p.name = name
    p.birthDate = birthDate
    p
  }
}