package io.github.chenfh5

import org.slf4j.LoggerFactory
import org.testng.annotations.{AfterClass, BeforeSuite, Test}


class TestCase {
  private val LOG = LoggerFactory.getLogger(getClass)

  @BeforeSuite
  def setUp() = {
    LOG.info("this is the setUp")
  }

  @AfterClass
  def cleanUp() = {
    LOG.info("this is the cleanUp")
  }

  @Test(enabled = true, priority = 1)
  def run01() = {
    LOG.info("this is the run01 func")
  }

}
