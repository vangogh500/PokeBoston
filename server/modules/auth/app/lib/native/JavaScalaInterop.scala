package lib.native

import scala.concurrent.ExecutionContext.Implicits.global
import java.util.concurrent.{Future => JFuture}
import scala.util.{Try, Success, Failure}
import scala.concurrent.{Future => SFuture, Promise}

/**
 * An extension of scala.collection.JavaConterters - a collection of interops between java and scala.
 * The following conversions are supported:
 * <ul>
 *    <li>java.util.concurrent.Future => scala.concurrent.Future</li>
 * </ul>
 */
object JavaScalaInterop {
  /**
   * Sealed trait which defines an interop as being able to be converted to scala.
   */
  sealed trait Scalable[S] {
    def asScala: S
  }
  /**
   * Interop for java.util.concurrent.Future => scala.concurrent.Future
   * @param jFuture Java future to be wrapped
   */
  implicit class JFutureInterop[T](jFuture: JFuture[T]) extends Scalable[SFuture[T]] {
    def asScala = {
      val promise = Promise[T]()
      new Thread(new Runnable {
        def run() { promise.complete(Try { jFuture.get }) }
      }).start
      promise.future transform {
        case Success(x) => Success(x)
        case Failure(e) => Failure(e.getCause())
      }
    }
  }
}
