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

package org.cccb.parallel.model;

import java.util.ArrayList;
import java.util.List;

import org.cccb.parallel.net.CCCBServerAPIWrapper;

public class Routes {
	private List<Route> allRoutes;
	
	public Routes readAllRoutes() {
		CCCBServerAPIWrapper server = new CCCBServerAPIWrapper();
		setAllRoutes(server.getAllRoutes());
		return this;
	}

	public List<Route> getAllRoutes() {
		if (this.allRoutes == null) {
			this.allRoutes = new ArrayList<Route>();
		}
		return allRoutes;
	}

	private void setAllRoutes(List<Route> allRoutes) {
		this.allRoutes = allRoutes;
	}
}
