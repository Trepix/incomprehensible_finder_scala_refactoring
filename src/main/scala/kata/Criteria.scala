package kata

object Criteria {
  type CriteriaType = Criteria

  sealed trait Criteria

  case object Closest extends Criteria

  case object Furthest extends Criteria
}