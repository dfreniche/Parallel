package org.cccb.parallel.test;

import org.cccb.parallel.model.Route;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRoute {

	@Test
	public void testCreateRoute() {
		//fail("Not yet implemented");
		
		Route r = new Route();
		r.setId(20);
		r.setName("1st route");
		r.setDescription("1st route description");
		
		assertEquals("1st route", r.getName());
		
	}

}
