package kata

import org.scalatest.BeforeAndAfterEach
import org.scalatest.matchers.should.Matchers.*
import org.scalatest.wordspec.AnyWordSpec

import java.util
import java.util.Date

class FinderTest extends AnyWordSpec with BeforeAndAfterEach {

  var sue: Thing = new Thing()
  var greg: Thing = new Thing()
  var sarah: Thing = new Thing()
  var mike: Thing = new Thing()

  override def beforeEach(): Unit = {
    sue.name = "Sue"
    sue.birthDate = new Date(50, 0, 1)
    greg.name = "Greg"
    greg.birthDate = new Date(52, 5, 1)
    sarah.name = "Sarah"
    sarah.birthDate = new Date(82, 0, 1)
    mike.name = "Mike"
    mike.birthDate = new Date(79, 0, 1)
  }

  "Finder" should {
    "Return empty results when given empty list" in {
      val list = new util.ArrayList[Thing]()

      val finder = new Finder(list)

      val result = finder.Find(FT.One)

      result.P1 shouldBe null
      result.P2 shouldBe null
    }

    "Return empty results when given one person" in {
      val list = new util.ArrayList[Thing]()
      list.add(sue)

      val finder = new Finder(list)

      val result = finder.Find(FT.One)

      result.P1 shouldBe null
      result.P2 shouldBe null
    }

    "Return closest two for two people" in {
      val list = new util.ArrayList[Thing]()
      list.add(sue)
      list.add(greg)

      val finder = new Finder(list)

      val result = finder.Find(FT.One)

      result.P1 shouldBe sue
      result.P2 shouldBe greg
    }

    "Return furthest two for two people" in {
      val list = new util.ArrayList[Thing]()
      list.add(mike)
      list.add(greg)

      val finder = new Finder(list)

      val result = finder.Find(FT.Two)

      result.P1 shouldBe greg
      result.P2 shouldBe mike
    }

    "Return furthest two for four people" in {
      val list = new util.ArrayList[Thing]()
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
      val list = new util.ArrayList[Thing]()
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
