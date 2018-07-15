package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth.services.authcaching

import scala.concurrent.Future

/**
 * AuthCaching Service to make access token look ups easier and faster
 */
trait AuthCachingService {
  /**
   * Add new entry to the cache
   * @param that Cache entry
   */
  def +(that: AuthCacheEntry): Future[Unit]
  /**
   * Determines whether entry exists in cache
   * @param that Cache entry
   */
  def contains(that: AuthCacheEntry): Future[Boolean]
}
