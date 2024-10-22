package kata

object Criteria {

  sealed trait Criteria

  case object Closest extends Criteria

  case object Furthest extends Criteria
}