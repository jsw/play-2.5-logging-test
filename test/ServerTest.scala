import org.scalatest.FunSpec
import play.api.mvc.Results._
import play.api.test.Helpers._
import play.api.test.WsTestClient
import play.core.server.Server
import play.api.mvc.Action
import com.typesafe.scalalogging.StrictLogging

class ServerTest extends FunSpec with StrictLogging {

  describe("WSTestClient") {
    it("should work with Server.withRouter() and print log1") {
      logger.error("log1")
      Server.withRouter() {
        case _ => Action {
          Ok("ok")
        }
      } { implicit port =>
        WsTestClient.withClient { client =>
          val result = await(client.url("/").get())
          assert(200 === result.status)
          assert("ok" === result.body)
        }
      }
    }

    it("should print log2") {
      logger.error("log2")
    }

    it("should print log3") {
      logger.error("log3")
    }
  }

}
