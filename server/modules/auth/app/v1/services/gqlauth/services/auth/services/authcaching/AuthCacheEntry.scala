package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth.services.authcaching

/**
 * Represents an entry in an auth cache
 * @param email User email
 * @param accessToken User access token
 */
case class AuthCacheEntry(email: String, accessToken: String) extends Ordered[AuthCacheEntry] {
  def compare(that: AuthCacheEntry): Int = accessToken compare that.accessToken
}
