package com.pokeboston.auth
package v1
package services
package gqlauth.services.auth.services.authcaching
package modules.jvm

import scala.concurrent.Future
import scala.collection.mutable.PriorityQueue

/**
 * Implementation of auth caching service using pure jvm memory
 */
case class JVMAuthCachingService(size: Int) extends AuthCachingService {
  private val cache = PriorityQueue[AuthCacheEntry]()

  def +(that: AuthCacheEntry) = Future {
    cache.enqueue(that)
  }
  def contains(that: AuthCacheEntry) = Future {
    cache.find(that)
  }
  // should be able to do the contains function in log(n) time
  private def binSearch(thath: AuthCacheEntry) = {
  }
}
