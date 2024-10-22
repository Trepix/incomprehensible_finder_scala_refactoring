package kata

import org.scalatest.BeforeAndAfterEach
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import java.util
import java.util.Calendar.*
import java.util.{Calendar, GregorianCalendar}

class FinderTest extends AnyWordSpec with BeforeAndAfterEach {

  var sue: Person = new Person()
  var greg: Person = new Person()
  var sarah: Person = new Person()
  var mike: Person = new Person()

  override def beforeEach(): Unit = {
    sue.name = "Sue"
    sue.birthDate = date(50, JANUARY, 1);
    greg.name = "Greg"
    greg.birthDate = date(52, JUNE, 1)
    sarah.name = "Sarah"
    sarah.birthDate = date(82, JANUARY, 1)
    mike.name = "Mike"
    mike.birthDate = date(79, JANUARY, 1)
  }

  private def date(year: Int, month: Int, day: Int) = {
    new GregorianCalendar(year, month, day).getTime
  }

  "Finder" should {
    "Return empty results when given empty list" in {
      val list = new util.ArrayList[Person]()

      val finder = new Finder(list)

      val result = finder.Find(FT.One)

      result.P1 shouldBe null
      result.P2 shouldBe null
    }

    "Return empty results when given one person" in {
      val list = new util.ArrayList[Person]()
      list.add(sue)

      val finder = new Finder(list)

      val result = finder.Find(FT.One)

      result.P1 shouldBe null
      result.P2 shouldBe null
    }

    "Return closest two for two people" in {
      val list = new util.ArrayList[Person]()
      list.add(sue)
      list.add(greg)

      val finder = new Finder(list)

      val result = finder.Find(FT.One)

      result.P1 shouldBe sue
      result.P2 shouldBe greg
    }

    "Return furthest two for two people" in {
      val list = new util.ArrayList[Person]()
      list.add(mike)
      list.add(greg)

      val finder = new Finder(list)

      val result = finder.Find(FT.Two)

      result.P1 shouldBe greg
      result.P2 shouldBe mike
    }

    "Return furthest two for four people" in {
      val list = new util.ArrayList[Person]()
      list.add(sue)
      list.add(sarah)
      list.add(mike)
      list.add(greg)

      val finder = new Finder(list)

      val result = finder.Find(FT.Two)

      result.P1 shouldBe sue
      result.P2 shouldBe sarah
    }

    "Return closest two for four people" in {
      val list = new util.ArrayList[Person]()
      list.add(sue)
      list.add(sarah)
      list.add(mike)
      list.add(greg)

      val finder = new Finder(list)

      val result = finder.Find(FT.One)


      result.P1 shouldBe sue
      result.P2 shouldBe greg
    }
  }
}
