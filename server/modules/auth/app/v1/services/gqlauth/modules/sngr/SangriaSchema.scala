package com.pokeboston.auth
package v1
package services
package gqlauth
package modules.sngr

import services.auth.AuthService
import implicits._

import sangria.schema._
import sangria.macros.derive.{deriveContextObjectType}


/**
 * Sangria schema
 * @see https://sangria-graphql.org/learn/
 */
object SangriaSchema {
  /**
   * Query type
   */
  private val queryType = ObjectType(
    "Query", fields[SangriaContext[Unit, AuthService], Unit](
      Field("debug", StringType, resolve = ctx ⇒ "Hello World"),
    ))
  /**
   * Mutation type
   */
  private val mutationType = deriveContextObjectType[SangriaContext[Unit, AuthService], AuthService, Unit](_.mutation)
  /**
   * Creates a sangria schema
   */
  def apply() = Schema(queryType, Some(mutationType))
}
