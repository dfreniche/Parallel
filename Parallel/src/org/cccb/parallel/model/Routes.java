package org.cccb.parallel.model;

import java.util.ArrayList;
import java.util.List;

public class Routes {
	private List<Route> allRoutes;
	
	public void readAllRoutes() {
		
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
