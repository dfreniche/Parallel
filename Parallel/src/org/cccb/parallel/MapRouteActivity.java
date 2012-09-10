package org.cccb.parallel;

import org.cccb.parallel.model.Route;
import org.cccb.parallel.model.constants.Parallel;
import org.cccb.parallel.net.CCCBServerAPIWrapper;

import android.os.Bundle;
import android.view.Menu;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MapRouteActivity extends MapActivity {

	 
	private MapView mapView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_route);
        
        mapView = (MapView)findViewById(R.id.mapView);
        mapView.setBuiltInZoomControls(true);
        mapView.getController().setCenter(new GeoPoint((int)(Parallel.latitude*1E6), (int)(Parallel.longitude*1E6) ));
        mapView.getController().setZoom(15);
        
        // get route selected in list
        
        long routeId = getIntent().getLongExtra("org.cccb.parallel.routeId", 0);
        
        Route r = (new CCCBServerAPIWrapper()).getRouteWithId(routeId);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_map_route, menu);
        return true;
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}
