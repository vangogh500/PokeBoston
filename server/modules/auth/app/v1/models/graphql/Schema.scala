package v1
package models
package graphql

import sangria.schema._

/**

object Schema {
  val Query = ObjectType(
    "Mutation", fields[SecureContext, Unit](
      Field("login", OptionType(StringType),
        arguments = UserNameArg :: PasswordArg :: Nil,
        resolve = (ctx) => ctx.ctx.login(ctx.arg(UserNameArg), ctx.arg(PasswordArg)))
    )
  )
}
**/
