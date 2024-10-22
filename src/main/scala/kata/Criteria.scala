package kata

sealed trait Criteria

object Criteria {
  case object Closest extends Criteria

  case object Furthest extends Criteria
}


