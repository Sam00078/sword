package io.github.chenfh5.lc

object TestOnly {

  def main(args: Array[String]): Unit = {
    val s1, s2 = "chenfh5_scala_test"
    println(s2)
    println(s1.eq(s2)) // string constant pool

    val arr1, arr2 = Array(1, 2)
    println(arr1.eq(arr2)) // false, since theri address is difference
    println(arr1 sameElements arr2) // true

    val arr3 = Array(1, 2)
    val arr4 = Array(1, 2)
    println(arr3.eq(arr4)) // false, since theri address is difference
    println(arr3 sameElements arr4) // true
  }

}
