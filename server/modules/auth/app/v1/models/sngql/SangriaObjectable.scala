package v1
package models
package sngql

import sangria.schema.{ObjectType}

/**
 * Defines a scala type that can also be defined as a sangria object type
 * @see https://sangria-graphql.org/learn/
 * @tparam T Scala type with an equivalent sangria object type
 */
trait SangriaObjectable[T] {
  /**
   * Defines a strategy for converting scala type to sangria object type
   * @tparam Ctx Sangria context type
   */
  def asSangriaObject[Ctx]: ObjectType[Ctx, T]
}
