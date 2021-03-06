package controllers

import org.scalatest.{DoNotDiscover, FlatSpec, Matchers}
import play.api.test.Helpers._
import play.api.test.FakeRequest
import test.ConfiguredTestSuite

@DoNotDiscover class ProfileActivityControllerTest extends FlatSpec with Matchers with ConfiguredTestSuite {

  val userId = "10000001"

  "CommenterActivity" should "return profile discussions component" in {
    val action = ProfileActivityController.profileDiscussions(userId)
    val fakeRequest = FakeRequest(GET, "/discussion/profile/"+ userId +"/discussions.json").withHeaders("host" -> "localhost:9000")
    val result = action(fakeRequest)

    status(result) should be(200)
    contentType(result).get should be("application/json")
    contentAsString(result) should include("class=\\\"activity-stream activity-stream--discussions\\\"")
  }

}
