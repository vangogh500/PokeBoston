package v1
package models
package sngql

/**
 * Sangria context
 * @see https://sangria-graphql.org/learn/
 * @param query Query context
 * @param mutation Mutation context
 * @tparam Q Query context type
 * @tparam M Mutation context type
 */
case class SangriaContext[Q, M](query: Q, mutation: M)
