package org.cccb.parallel.test;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;

import org.cccb.parallel.model.POI;
import org.cccb.parallel.model.Route;
import org.cccb.parallel.model.Routes;
import org.cccb.parallel.net.CCCBServerAPIWrapper;
import org.junit.Test;

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
	
	
	@Test
	public void testGetRoutesFromServer() {
		
		List <Route> routes = (new Routes()).readAllRoutes().getAllRoutes();
        for (Route r : routes) {
			System.out.println("Route: " + r.getName() + ", " + r.getDescription());
			
			List <POI> pois = r.getRoutePOIs();
			for (Iterator<POI> iterator = pois.iterator(); iterator.hasNext();) {
				POI poi = (POI) iterator.next();
				System.out.println(poi.getAdrress());
				
			}
			System.out.println();
		}
		
		//assertEquals("1st route", r.getName());
		
	}

	@Test
	public void testGetOneRouteWithId() {
		Route r = (new CCCBServerAPIWrapper()).getRouteWithId(1);
		
		System.out.println(r.getName());
		List <POI> l = r.getRoutePOIs();
		for (Iterator<POI> iterator = l.iterator(); iterator.hasNext();) {
			POI poi = (POI) iterator.next();
			System.out.println(poi.getDescription());
		}
		
	}
	
}
