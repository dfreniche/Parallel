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

package org.cccb.parallel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.cccb.parallel.model.Route;
import org.cccb.parallel.model.Routes;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class RoutesListActivity extends ListActivity {

	ListView list;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_routes_list);

		Toast.makeText(this.getApplicationContext(), "Reading from the Internet", Toast.LENGTH_LONG).show();

		AccessCCCBData task = new AccessCCCBData();
		task.execute( );
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_routes_list, menu);
		return true;
	}


	private class AccessCCCBData extends AsyncTask<Void, Void, String> {
		List <Route> routes;
		@Override
		protected String doInBackground(Void... thisSpaceIntencionallyLeftBlank) {
			try {
				Routes r = (new Routes()).readAllRoutes();
				routes = r.getAllRoutes();
			} catch (Exception e) {
				Log.e("ERROR", "Error in AsyncTask");
			}
			if (routes != null && routes.size() == 0) {
				return "ERROR";
			}
			return "";
		}

		@Override
		protected void onPostExecute(String result) {
			if ("ERROR".equalsIgnoreCase(result)) {
				Toast.makeText(RoutesListActivity.this, "Error connecting", Toast.LENGTH_LONG).show();
				finish();
			}
			List <String> names = new ArrayList<String>();

			for (Route r : routes) {
				names.add(r.getName());
				System.out.println(r.getName());
			}

			ArrayAdapter<String> adapter = new ArrayAdapter<String>(RoutesListActivity.this, android.R.layout.simple_list_item_1, names );

			RoutesListActivity.this.setListAdapter(adapter);
 
			list = (ListView)findViewById(android.R.id.list);
			list.setOnItemClickListener(new OnItemClickListener() {

				public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
					Log.d("",""+routes.get(arg2).getName());
					Intent i = new Intent(RoutesListActivity.this, MapRouteActivity.class);
					i.putExtra("org.cccb.parallel.routeId", routes.get(arg2).getId());
					startActivity(i);
				}

			});

		}
	}



}
