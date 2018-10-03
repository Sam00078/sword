package io.github.chenfh5.lc.string

object L0443_StringCompression {

  // @see https://leetcode.com/problems/string-compression/discuss/92559/Simple-Easy-to-Understand-Java-solution
  def compress(chars: Array[Char]): Int = {
    var index, indexNew = 0 // index new to record the compress result, and the result is overwritten the raw input chararray

    while (index < chars.length) {
      var (curChar, count) = (chars(index), 0) // reset count for next diff char
      // find the consecutive same char
      while (index < chars.length && chars(index) == curChar) {
        index += 1 // move right in one step
        count += 1
      }
      chars(indexNew) = curChar // since curChar have already compare, it would no longer use. Overwritten it to match in-place
      indexNew += 1
      // convert count
      if (count > 1) {
        count.toString.foreach(x => {
          chars(indexNew) = x
          indexNew += 1
        })
      }
    }
    println(chars.take(indexNew).toList) // debug only
    indexNew
  }

  def main(args: Array[String]) {
    val chars = Array[Char]('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'a', 'a') //ab12a3
    val res = compress(chars)
    print(res)
    assert(res == 6)
  }

}
