package v1
package services

/**
 * Implementation of GQL service builder using Sangria
 */
object SangriaGQLServiceBuilder extends GQLServiceBuilder {
  /**
   * Creates an instance of a GQL service implemented using Sangria
   * @param authService Auth service to use
   */
  def build(authService: AuthService) = SangriaGQLService(authService)
}
