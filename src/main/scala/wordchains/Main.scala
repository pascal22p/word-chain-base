package wordchains
import scala.io.Source

object Main extends App {

  val dictionary = Source.fromResource("dictionary.txt").getLines().toList

  WordChain.run(args(0), args(1), dictionary).foreach(println)
}

object WordChain {

  def countChanges(word: String)(ref: String): Boolean = {
    val boolList = (word, ref).zipped.map { (c1, c2) =>
      c1 == c2
    }
    boolList.count(_ == false) == 1
  }

  def getNextWord(dictionary: List[String], currentWord: String, endWord: String): List[String] = {
    val nextWordOption = dictionary.find(countChanges(currentWord))
    nextWordOption match {
      case Some(nextWord) if nextWord == endWord => currentWord:: List(endWord)
      case None => List(currentWord)
      case Some(nextWord) => {
        val dic = dictionary.filterNot(_ == nextWord).filterNot(_ == currentWord)
        currentWord :: getNextWord(dic, nextWord, endWord)
      }
    }
  }

  def run(word1: String, word2: String, dictionary: List[String]): List[String] = {
    getNextWord(dictionary.filter(_.length == word1.length), word1: String, word2: String)
  }
}