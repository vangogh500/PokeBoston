package auth

import javax.inject.Inject

object AuthRouter @Inject()(controller: PostController) extends SimpleRouter {

}
