package io.github.chenfh5.leetcode.string

object L0609_FindDuplicateFileinSystem {

  // @see https://leetcode.com/problems/find-duplicate-file-in-system/discuss/174548/Short-Scala-solution
  def findDuplicate(paths: Array[String]): List[List[String]] = {
    val regex = "(.+)\\((.+)\\)".r

    paths.toList
      .flatten(_.split(' ').toSeq match {
        case (path +: files) => files.map {
          case regex(fileName, content) => content -> (path + "/" + fileName)
        }
      })
      .groupBy(_._1) // group by content, (content, ListA)
      .values // collect all group values
      .filter(_.size > 1) // need at least two files
      .map(_.map(_._2)).toList // drop content
  }

  def main(args: Array[String]) {
    val input = Array("root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)")
    val res = findDuplicate(input)
    print(res)
    val expect = List(List("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"), List("root/a/1.txt", "root/c/3.txt"))
    assert(res == expect)
  }

}
