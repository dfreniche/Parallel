package org.cccb.parallel;

import java.util.ArrayList;
import java.util.List;

import org.cccb.parallel.model.Route;
import org.cccb.parallel.model.Routes;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RoutesListActivity extends ListActivity {

	ListView list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes_list);
        
        List <String> names = new ArrayList<String>();
        final List <Route> routes = (new Routes()).readAllRoutes().getAllRoutes();
        for (Route r : routes) {
			names.add(r.getName());
			System.out.println(r.getName());
		}
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names );
        
        setListAdapter(adapter);
        
        list = (ListView)findViewById(android.R.id.list);
        list.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				Log.d("",""+routes.get(arg2).getName());
			}
        	
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_routes_list, menu);
        return true;
    }

    
}
