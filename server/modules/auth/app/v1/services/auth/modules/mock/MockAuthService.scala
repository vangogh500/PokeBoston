package com.pokeboston.auth
package v1
package services
package auth
package modules.mock

import javax.inject._
// implicits
import scala.concurrent.ExecutionContext
import scala.collection.JavaConverters._
import lib.native.JavaScalaInterop._
// specs
import errors._
import responses._
// models
import scala.util.{Success, Failure}
//lib
import scala.concurrent.Future

/**
 * Implementation of auth service using mock (works offline)
 */
@Singleton
class MockAuthService @Inject()(implicit ec: ExecutionContext) extends AuthService {
  def login(email: String, password: String) = Future {
    LoginResponse(
      accessToken = Some("test"),
      refreshToken = Some("test")
    )
  }

  def register(email: String, password: String) = Future {
    200
  }
}