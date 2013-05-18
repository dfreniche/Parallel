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

package org.cccb.parallel.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.cccb.parallel.model.POI;
import org.cccb.parallel.model.Route;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class CCCBServerAPIWrapper {

	private static final String urlBase = "http://10.0.1.11:4567";

	public Route getRouteWithId(long routeId) {
		Route r = new Route();
		// get JSON data
		JSONObject jObject = JSONUtil.getJSONFromHttpRequest(urlBase + "/getroute?id="+ routeId +"&locale=ES_es");
		if (jObject == null) {
			return null;
		}

		// convert to Java objects
		try {
			r.setId(jObject.getLong("id"));
			r.setDescription(jObject.getString("description"));
			r.setName(jObject.getString("name"));
			r.setTimeNeeded(jObject.getLong("timeNeeded"));
			// POIs
			r.setRoutePOIs(this.readPOIs(jObject));


		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	
	public POI getPoiWithId(long poiId) {
		POI p = new POI();
		// get JSON data
		JSONObject jObject = JSONUtil.getJSONFromHttpRequest(urlBase + "/poidetail?id="+ poiId +"&locale=ES_es");
		if (jObject == null) {
			return null;
		}
		// convert to Java objects
		try {
			p.setId(jObject.getLong("id"));
			p.setDescription(jObject.getString("description"));
			p.setName(jObject.getString("name"));
			p.setAddress(jObject.getString("address"));

			p.setLatitude(jObject.getLong("latitude"));
			p.setLongitude(jObject.getLong("longitude"));

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	public List<Route> getAllRoutes(){
		// get JSON data
		JSONObject jObject = JSONUtil.getJSONFromHttpRequest(urlBase + "/allroutes?locale=ES_es");
		JSONArray routes;
		List<Route> l = new ArrayList<Route>();
		if (jObject == null) {
			return null;
		}

		// convert to Java objects
		try {
			routes = jObject.getJSONArray("allroutes");
			for (int i = 0; i < routes.length(); i++) {
				JSONObject jo = routes.getJSONObject(i);
				Route r = new Route();
				r.setId(jo.getLong("id"));
				r.setDescription(jo.getString("description"));
				r.setName(jo.getString("name"));

				// POIs

				r.setRoutePOIs(this.readPOIs(jo));

				l.add(r);
			}
		} catch (JSONException e) {
			Log.e("CCCB", "Error parsing JSON");
			e.printStackTrace();
		}
		return l;

	}

	private List<POI> readPOIs(JSONObject jo) {
		List <POI> l = new ArrayList<POI>();
		JSONArray pois = null;
		try {
			pois = jo.getJSONArray("pois");
			if (pois != null) {
				for (int i=0; i<pois.length(); i++) {
					JSONObject poiJson = pois.getJSONObject(i);
					POI p = new POI();
					p.setId(poiJson.getLong("id"));
					p.setAddress(poiJson.getString("address"));
					p.setLatitude(poiJson.getDouble("latitude"));
					p.setLongitude(poiJson.getDouble("longitude"));
					p.setDescription(poiJson.getString("description"));
					// something missing here
					
					l.add(p);
				}
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}
}
