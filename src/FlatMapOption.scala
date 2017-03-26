def checkUserEmail(id: UserId): Option[Boolean] = {
  getUserFromDB(id).flatMap { user =>
    user.email.map { email =>
      check(email)
    }
  }
}
