package org.cccb.parallel;

import java.util.ArrayList;
import java.util.List;

import org.cccb.parallel.model.Route;
import org.cccb.parallel.model.Routes;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class RoutesListActivity extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes_list);
        
        List <String> names = new ArrayList<String>();
        List <Route> routes = (new Routes()).readAllRoutes().getAllRoutes();
        for (Route r : routes) {
			names.add(r.getName());
			System.out.println(r.getName());
		}
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names );
        
        setListAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_routes_list, menu);
        return true;
    }

    
}
