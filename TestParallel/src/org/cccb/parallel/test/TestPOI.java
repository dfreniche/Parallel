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

import static literal.collection.List;

import java.util.List;

import static junit.framework.Assert.*;

import org.cccb.parallel.model.POI;
import org.junit.Test;

public class TestPOI {

	@Test
	public void testCreatePOI() {
		POI p = new POI();
		
		p.setId(10);
		p.setAdrress("Address of test");
		p.setLatitude(0.8888f);
		p.setLongitude(1.98);
		
		List<String> tags = List("Tag1", "Tag2", "Tag3");
		p.setTags(tags);
		
		assertEquals(10, p.getId());
		assertEquals("Tag1", p.getTags().get(0));
		
		
		
	}

}
