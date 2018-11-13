package io.github.chenfh5.lc.string


object L0722_RemoveComments {

  // 1xxx
  /* 2xxx */
  // @see https://leetcode.com/problems/remove-comments/discuss/109197/One-pass-solution-in-Java
  def removeComments(source: Array[String]): List[String] = {
    import scala.collection.mutable.ListBuffer
    val (res, sb) = (ListBuffer[String](), new StringBuilder())
    var isComment = false
    for (s <- source) {
      var i = -1
      var stopLoop = false
      while (i + 1 < s.length && !stopLoop) {
        i += 1
        isComment match {
          case false =>
            if (s(i) == '/' && i < s.length - 1 && s(i + 1) == '/') {
              stopLoop = true // drop this line
            } else if (s(i) == '/' && i < s.length - 1 && s(i + 1) == '*') {
              isComment = true // begin to drop block
              i += 1
            } else sb.append(s(i))
          case true => // already have `/*`, need `*/` to close
            if (s(i) == '*' && i < s.length - 1 && s(i + 1) == '/') {
              isComment = false // stop to drop block
              i += 1
            }
        }
      }
      if (!isComment && sb.nonEmpty) {
        res.append(sb.toString())
        sb.clear()
      }
    }
    res.toList
  }

  def main(args: Array[String]) {
    val input = Array("a/*comment", "line", "more_comment*/b")
    val res = removeComments(input)
    print(res)
    val expect = List("ab")
    assert(res == expect)
  }

}
