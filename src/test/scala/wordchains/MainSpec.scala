package wordchains

import org.scalatest._

class MainSpec extends WordSpec with Matchers {

  val testDictionary = List("cat", "vat", "van", "pan", "pun")

  "run" should {
    "map from cat to pun" in {
      WordChain.run("cat", "pun", testDictionary) shouldBe testDictionary
    }
  }
}
