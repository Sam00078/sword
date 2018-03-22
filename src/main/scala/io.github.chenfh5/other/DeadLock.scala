package io.github.chenfh5.other

object DeadLock {

  class DeadLock(obj1: Object, obj2: Object) extends Runnable {

    /**
      * @see https://www.jianshu.com/p/4ff1bca955c0
      *      https://stackoverflow.com/questions/34877487/how-to-use-synchronized-in-scala
      */
    override def run(): Unit = {
      obj1.synchronized {
        println(s"${Thread.currentThread().getName}锁住了obj1=$obj1")
        Thread.sleep(1000)
        obj2.synchronized {
          println(s"${Thread.currentThread().getName}锁住了obj2=$obj2")
        }
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println("this is the begin")
    val str1 = new String("one")
    val str2 = new String("two")

    new Thread(new DeadLock(str1, str2)).start()
    new Thread(new DeadLock(str2, str1)).start()

    println("this is the end")
  }

}
