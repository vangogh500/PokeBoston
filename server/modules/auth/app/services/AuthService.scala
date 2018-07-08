package services

/**
 * Defines an auth service
 */
trait AuthService {
  /**
   * Login business logic
   */
  def login(email: String, password: String): Unit
  /**
   * Registration business logic.
   */
  def register(email: String, password: String): Unit
}
