package com.pokeboston.auth
package v1
package services

/**
 * v1 errors
 */
package object errors {
  /**
   * Auth service exception
   */
  sealed trait AuthServiceException
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
