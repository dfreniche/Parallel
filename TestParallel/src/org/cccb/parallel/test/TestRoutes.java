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
		
		
		System.out.println("Hola");
		System.out.println( l.get(0).getDescription());
		
		assertEquals("Some desc in Spanish", l.get(0).getDescription());
		
		
		
		assertEquals("Other desc", l.get(1).getDescription());
		
		System.out.println(l.get(1).getDescription());

	}

}
