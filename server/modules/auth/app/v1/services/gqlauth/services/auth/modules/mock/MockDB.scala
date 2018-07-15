package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth
package modules.mock


/**
 * DB for mock implementation of auth service
 */
object MockDB {
  /**
   * User collection
   */
  var users = Seq(
    MockUser("kmatsuda@athenium.com", "kbbq")
  )
}
