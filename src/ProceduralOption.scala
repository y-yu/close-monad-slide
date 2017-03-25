def checkUserEmail(id: UserId): Option[Boolean] = {
  val userOpt: Option[User] = getUserFromDB(id)

  if (userOpt.isDefined) {
    val user: User = userOpt.get
    val emailOpt: Option[Email] = user.email

    if (emailOpt.isDefined) {
      Some(check(emailOpt.get))
    } else {
      None
    }
  } else {
    None
  }
}
