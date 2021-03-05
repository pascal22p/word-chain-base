package wordchains

import org.scalatest._

import scala.util.Random

class MainSpec extends WordSpec with Matchers {

  val testDictionary = List("cat", "vat", "van", "pun", "pan", "rty")

  (1 to 10).map { i =>
    s"run $i" should {
      "map from cat to pun" in {
        WordChain.run("cat", "pun", Random.shuffle(testDictionary)) shouldBe List("cat", "vat", "van", "pan", "pun")
      }
    }
  }

  "run" should {
    "countChanges" should {
      "return true if only one change" in {
        WordChain.countChanges("cat")("pun") shouldBe false
        WordChain.countChanges("cat")("bat") shouldBe true
        WordChain.countChanges("cat")("cot") shouldBe true
        WordChain.countChanges("cat")("bag") shouldBe false
      }
    }
  }
}
