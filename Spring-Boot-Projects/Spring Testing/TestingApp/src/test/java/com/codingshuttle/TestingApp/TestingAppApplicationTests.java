package com.codingshuttle.TestingApp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
@Slf4j
class TestingAppApplicationTests
{

	@Test
    @Disabled
	void contextLoads()
    { }

    @BeforeEach
    void setUp(){log.info("before each test , used to setup something before each test  ");}

    @AfterEach
    void setDown(){log.info("After each test , used to setdown  resources  before each test  ");}

    @BeforeAll
  static   void setUpOnce(){log.info("before all tests , used to setup something before all tests ");}

    @AfterAll
    static void setDownOnce() {log.info("after all tests , used to setDown something after all tests");}

    @Test
    void testOne() { log.info("test one is running"); }

    @Test
    void testTwo() { log.info("test two is running"); }

    @Test
    void testAddition()
    {
        int a = 5 ;
        int b = 5;

        int result = addTwoNumbers(a, b);

        Assertions.assertEquals(10, result);         // import from JUnit /api
        // use assertEquals based on datatypes , there are multiple methods same named , but operate on diff datatypes

        log.info("test addition is running");

        // if this equals then test would be pass
    }

    // lets say this method is not test , written somewhere else , lets check if it works by Assertions
    int addTwoNumbers(int a, int b){return a+b;}

}
