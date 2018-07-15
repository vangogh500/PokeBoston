package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth

/**
 * Defines a response from an auth service for v1
 * @see services.AuthService
 * @param accessToken Access token
 * @param refreshToken Refresh token
 */
case class AuthServiceResponse(accessToken: Option[String], refreshToken: Option[String])
