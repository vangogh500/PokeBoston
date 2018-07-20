package com.pokeboston.auth
package v1
package services
package auth
package modules.mock

import scala.collection.mutable.{Set}

/**
 * DB for mock implementation of auth service
 */
object MockDB {
  /**
   * User collection (uses mutable scala set)
   * @see https://www.scala-lang.org/api/2.12.0/scala/collection/mutable/Set.html
   */
  val users = Set(
    MockUser("kmatsuda@athenium.com", "kbbq")
  )
}
