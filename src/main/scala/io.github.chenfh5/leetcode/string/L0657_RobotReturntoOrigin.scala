package io.github.chenfh5.leetcode.string

object L0657_RobotReturntoOrigin {

  def judgeCircle(moves: String): Boolean = {
    var vertical, horizontal = 0
    // iterator
    for (action <- moves) {
      action match {
        case 'U' => vertical += 1
        case 'D' => vertical -= 1
        case 'L' => horizontal -= 1
        case 'R' => horizontal += 1
        case _ => throw new IllegalArgumentException("can not understand this action")
      }
    }
    vertical == 0 && horizontal == 0
  }

  def main(args: Array[String]) {
    val input = "LL"
    val res = judgeCircle(input)
    print(res)
    assert(!res)
  }

}
