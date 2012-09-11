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

public class CCCBServerAPIWrapper {

	private static final String urlBase = "http://10.0.1.10:4567";


	private JSONObject getJSONFromHttpRequest(String httpRequest) {
		BufferedReader in = null;
		JSONObject jsonObject = null;
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet(httpRequest);
			HttpResponse response = client.execute(request);


			in = new BufferedReader(
					new InputStreamReader(
							response.getEntity().getContent(), "UTF-8"));

			StringBuffer sb = new StringBuffer("");
			String line = "";
			String NL = System.getProperty("line.separator");
			while ((line = in.readLine()) != null) {
				sb.append(line + NL);
			}
			in.close();

			String page = sb.toString();
			// System.out.println(page);

			jsonObject = new JSONObject(page);


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return jsonObject;

	}


	public Route getRouteWithId(long routeId) {
		Route r = new Route();
		// get JSON data
		JSONObject jObject = getJSONFromHttpRequest(urlBase + "/getroute?id="+ routeId +"&locale=ES_es");


		// convert to Java objects
		try {
			r.setId(jObject.getLong("id"));
			r.setDescription(jObject.getString("description"));
			r.setName(jObject.getString("description"));

			// POIs

			r.setRoutePOIs(this.readPOIs(jObject));


		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	public List<Route> getAllRoutes(){
		// get JSON data
		JSONObject jObject = getJSONFromHttpRequest(urlBase + "/allroutes?locale=ES_es");
		JSONArray routes;
		List<Route> l = new ArrayList<Route>();


		// convert to Java objects
		try {
			routes = jObject.getJSONArray("allroutes");
			for (int i = 0; i < routes.length(); i++) {
				JSONObject jo = routes.getJSONObject(i);
				Route r = new Route();
				r.setId(jo.getLong("id"));
				r.setDescription(jo.getString("description"));
				r.setName(jo.getString("description"));

				// POIs

				r.setRoutePOIs(this.readPOIs(jo));

				l.add(r);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
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
					p.setAdrress(poiJson.getString("address"));
					p.setLatitude(poiJson.getDouble("latitude"));
					p.setLongitude(poiJson.getDouble("longitude"));
					p.setDescription(poiJson.getString("description"));
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