package wordchains

import org.scalatest._

class MainSpec extends WordSpec with Matchers {

  val testDictionary = List("cat", "vat", "van", "pan", "pun")

  "run" should {
    "map from cat to pun" in {
      WordChain.run("cat", "pun", testDictionary) shouldBe testDictionary
    }
  }

  "countChanges" should {
    "return true if only one change" in {
      WordChain.countChanges("cat")("pun") shouldBe false
      WordChain.countChanges("cat")("bat") shouldBe true
      WordChain.countChanges("cat")("cot") shouldBe true
      WordChain.countChanges("cat")("bag") shouldBe false
    }
  }
}
