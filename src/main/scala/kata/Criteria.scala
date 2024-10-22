package kata

object Criteria {
  type Criteria = Criteria2

  val Closest = Closest2
  val Furthest = Furthest2

  sealed trait Criteria2

  case object Closest2 extends Criteria2

  case object Furthest2 extends Criteria2
}