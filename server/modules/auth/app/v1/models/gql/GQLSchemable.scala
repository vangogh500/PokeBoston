package v1
package models
package gql

trait GQLSchemable[G] {
  def gqlSchema: G
}
