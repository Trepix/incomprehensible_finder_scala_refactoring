package kata

import java.util.Date

class Thing {

  var name: String = _

  var birthDate: Date = _

  def getName(): String = name

  def setName(name: String): Unit = {
    this.name = name
  }

  def getBirthDate(): Date = birthDate

  def setBirthDate(birthDate: Date): Unit = {
    this.birthDate = birthDate
  }
}