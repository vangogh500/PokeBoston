package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth
package modules.mock

import javax.inject._
// implicits
import scala.concurrent.ExecutionContext
import scala.collection.JavaConverters._
import lib.native.JavaScalaInterop._
// specs
import errors._
// models
import scala.util.{Success, Failure}
//lib
import scala.concurrent.Future

/**
 * Implementation of auth service using mock (works offline)
 */
@Singleton
class MockAuthService @Inject()(implicit ec: ExecutionContext) extends AuthService {
  def login(email: String, password: String) = {
    MockDB.find()
  }

  def register(email: String, password: String) = Future {
    AuthServiceResponse(
      accessToken = Some("test"),
      refreshToken = Some("test")
    )
  }
}
