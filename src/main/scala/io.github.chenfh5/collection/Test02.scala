package io.github.chenfh5.collection


/**
  * @see https://github.com/Wang-Jun-Chao/coding-interviews/blob/master/src/Test02.java
  */
object Test02 {
  private val instance = "I am singleton"

  def getInstance() = {
    instance
  }


  def main(args: Array[String]) {
    assert(Test02.getInstance == Test02.getInstance())
  }

}
