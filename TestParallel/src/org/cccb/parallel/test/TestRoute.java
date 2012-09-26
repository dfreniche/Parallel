/*

MIT - Licence

Copyright (c) 2012 Diego Freniche

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and 
to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of
 the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED 
TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL 
THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
DEALINGS IN THE SOFTWARE.

*/

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
