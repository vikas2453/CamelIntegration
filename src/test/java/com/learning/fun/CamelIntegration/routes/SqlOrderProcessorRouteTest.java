package com.learning.fun.CamelIntegration.routes;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class SqlOrderProcessorRouteTest {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Before
	public void setUp() {
		
		
	}
	@Test
	//@Transactional
	public void testSqlOrderProcessorRouteSuccess() throws InterruptedException {
		//jdbcTemplate.execute(" insert into camelprocessing values(4, 'OrderProcessor', '{\"firstName\":\"ikas\", \"email\":\"vikas243@gmail.ccom\"}', 'N')");
		Thread.sleep(500);
		int total=jdbcTemplate.queryForObject("select count(id) from Orders.camelProcessing where status ='P'" , Integer.class);
		assertTrue(total==2);
	}
	
	
	@After
	public void tearDown() {
		
	}

}
