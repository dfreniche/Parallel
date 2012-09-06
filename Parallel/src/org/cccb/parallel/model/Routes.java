package org.cccb.parallel.model;

import java.util.ArrayList;
import java.util.List;

import org.cccb.parallel.net.CCCBServerAPIWrapper;

public class Routes {
	private List<Route> allRoutes;
	
	public void readAllRoutes() {
		CCCBServerAPIWrapper server = new CCCBServerAPIWrapper();
		setAllRoutes(server.getAllRoutes());
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
