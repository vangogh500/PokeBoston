package com.pokeboston.auth
package v1
package services
package gqlauth
package modules.sngr

/**
 * Sangria context
 * @see https://sangria-graphql.org/learn/
 * @param query Query context
 * @param mutation Mutation context
 * @tparam Q Query context type
 * @tparam M Mutation context type
 */
case class SangriaContext[Q, M](query: Q, mutation: M)
