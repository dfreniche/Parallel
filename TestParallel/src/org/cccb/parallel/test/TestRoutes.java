package org.cccb.parallel.test;

import java.util.List;

import org.cccb.parallel.model.Route;
import org.cccb.parallel.model.Routes;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRoutes {

	@Test
	public void test() {
		//fail("Not yet implemented");
		Routes r = new Routes();
		r.readAllRoutes();
		List <Route> l =  r.getAllRoutes();
		
		assertEquals("Some desc in Spanish", l.get(0).getDescription());
		
		assertEquals("Other desc", l.get(1).getDescription());

	}

}
