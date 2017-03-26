def checkUserEmail(id: UserId): Option[Boolean] = {
  for {
    user  <- getUserFromDB(id)
    email <- user.email
  } yield check(email)
}
