package v1
package services

/**
 * Defines a GQL service builder
 */
trait GQLServiceBuilder {
  /**
   * Builds a gql service from an auth service
   * @param authService Auth service to use
   */
  def build(authService: AuthService): GQLService
}
