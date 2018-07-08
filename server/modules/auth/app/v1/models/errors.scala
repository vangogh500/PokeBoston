package v1
package models

package object errors {
  sealed trait AuthServiceException extends Exception
  case object ClientAuthException extends AuthServiceException
}
