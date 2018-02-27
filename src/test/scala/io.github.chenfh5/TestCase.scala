package io.github.chenfh5

import org.slf4j.LoggerFactory
import org.testng.annotations.{AfterClass, BeforeSuite, Test}

import io.github.chenfh5.common.{OwnConstant, OwnUtils, TreeOrder}


class TestCase {
  private val LOG = LoggerFactory.getLogger(getClass)

  @BeforeSuite
  def setUp(): Unit = {
    LOG.info("this is the setUp")
  }

  @AfterClass
  def cleanUp(): Unit = {
    LOG.info("this is the cleanUp")
  }

  @Test(enabled = true, priority = 1)
  def run01(): Unit = {
    LOG.info("this is the run01 func")
  }

  @Test(enabled = true, priority = 1)
  def printTreeNodeTest(): Unit = {
    val input = OwnConstant().treeRoot
    println()
    OwnUtils.printTree(input, TreeOrder.preOrder)
    println()
    OwnUtils.printTreeNotInRec(input, TreeOrder.preOrder)

    println()
    OwnUtils.printTree(input, TreeOrder.inOrder)
    println()
    OwnUtils.printTreeNotInRec(input, TreeOrder.inOrder)

    println()
    OwnUtils.printTree(input, TreeOrder.postOrder)
    println()
    OwnUtils.printTreeNotInRec(input, TreeOrder.postOrder)
  }

}
