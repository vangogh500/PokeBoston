package v1
package models
package gql

import sangria.schema.ObjectType

trait GQLObjectable[Ctx, T] extends GQLSchemable[ObjectType[Ctx, T]] {
  def gqlSchema[Ctx]: ObjectType[Ctx, T]
}
