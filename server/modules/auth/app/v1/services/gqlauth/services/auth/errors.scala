package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth

/**
 * v1 errors
 */
package object errors {
  /**
   * Auth service exception
   */
  sealed trait AuthServiceException
  /**
   * Client syntax exception - The request was not of right syntax (invalid email, password)
   * @param msg Description
   */
  case class ClientSyntaxException(msg: String) extends Exception(msg) with AuthServiceException
  /**
   * Client auth exception - Client does not have permission (equivalent to 401)
   * @param msg Description
   */
  case class ClientAuthException(msg: String) extends Exception(msg) with AuthServiceException
  /**
   * Server side exception - Something went wrong on the server (equivalent to 500)
   * @param msg Description
   */
  case class ServerException(msg: String) extends Exception(msg) with AuthServiceException
}
