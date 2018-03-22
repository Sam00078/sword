package io.github.chenfh5.other

import java.util.concurrent.{ArrayBlockingQueue, BlockingQueue}

import scala.util.Random


object ProducerConsumer {

  /**
    * @see http://blog.csdn.net/chenchaofuck1/article/details/51660119
    */
  class Producer(blockingQueue: BlockingQueue[Int]) extends Runnable {
    @volatile private var shutdownFlag = false
    private val random = new Random()

    override def run(): Unit = {
      while (!shutdownFlag) {
        val msg = random.nextInt(100)
        blockingQueue.put(msg)
        println(s"${Thread.currentThread.getName}+生成了msg=$msg")
        Thread.sleep(50)
      }
    }

    def shutDown(): Unit = shutdownFlag = true
  }

  class Consumer(blockingQueue: BlockingQueue[Int]) extends Runnable {
    @volatile private var shutdownFlag = false

    override def run(): Unit = {
      while (!shutdownFlag) {
        val msg = blockingQueue.take()
        println(s"${Thread.currentThread.getName}+消费了msg=$msg")
        Thread.sleep(50)
      }
    }

    def shutDown(): Unit = shutdownFlag = true
  }

  def main(args: Array[String]): Unit = {
    println("this is the begin")
    val blockingQueue = new ArrayBlockingQueue[Int](100)
    val producer = new Producer(blockingQueue)
    val consumer = new Consumer(blockingQueue)

    for (i <- 0 until 10) {
      if (i < 5) new Thread(producer, s"producer_$i").start()
      else new Thread(consumer, s"consumer_${i - 5}").start()
    }

    println(s"再5秒后关闭生产者, ${System.currentTimeMillis()}")
    Thread.sleep(2000)
    producer.shutDown()
    println(s"再5秒后关闭消费者, ${System.currentTimeMillis()}")
    Thread.sleep(2000) //这里会有消费者消费空队列导致一直阻塞，hold住，可以加timeout来解决。
    consumer.shutDown()

    println("this is the end")
  }

}
