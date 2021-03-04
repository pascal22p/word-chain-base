package wordchains
import scala.io.Source

object Main extends App {

  val dictionary = Source.fromResource("dictionary.txt").getLines().toList

  WordChain.run(args(0), args(1), dictionary).foreach(println)
}

object WordChain {

  def run(word1: String, word2: String, dictionary: List[String]): List[String] = ???
}