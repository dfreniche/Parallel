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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.cccb.parallel.model.POI;
import org.cccb.parallel.model.Route;
import org.cccb.parallel.model.constants.Parallel;
import org.cccb.parallel.net.CCCBServerAPIWrapper;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.OverlayItem;

public class MapRouteActivity extends MapActivity {


	private MapView mapView;
	ParallelMapPin mp;

	private View viewBubble;
	private ViewGroup parentBubble;
	private OverlayItem item;
	private GeoPoint geo;

	private MyLocationOverlay me = null;
	
	private Route r;
	private int selectedPOIIndex;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_route);

		mapView = (MapView)findViewById(R.id.mapView);
		mapView.setBuiltInZoomControls(true);


		// get route selected in list

		long routeId = getIntent().getLongExtra("org.cccb.parallel.routeId", 0);

		if (routeId == 0) {
			Toast.makeText(this, "No Route in list", Toast.LENGTH_LONG).show();

		}
		r = (new CCCBServerAPIWrapper()).getRouteWithId(routeId);

		Drawable marker = getResources().getDrawable(R.drawable.information);
		int markerWidth = marker.getIntrinsicWidth();
		int markerHeight = marker.getIntrinsicHeight();
		marker.setBounds(0, markerHeight, markerWidth, 0);


		mp = new ParallelMapPin(marker);
		mp.addPois(marker, r.getRoutePOIs());
		mapView.getOverlays().add(mp);




		mapView.getController().setCenter(new GeoPoint((int)(Parallel.latitude*1E6), (int)(Parallel.longitude*1E6) ));
		mapView.getController().setZoom(15);


		me = new MyLocationOverlay(this, mapView);
		mapView.getOverlays().add(me);

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


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_S) {
			mapView.setSatellite(!mapView.isSatellite());
			return (true);
		} else if (keyCode == KeyEvent.KEYCODE_Z) {
			mapView.displayZoomControls(true);
			return (true);
		}

		return (super.onKeyDown(keyCode, event));
	}


	private void dimissbubble(){
		if (viewBubble != null) {
			mapView.removeView(viewBubble);
			viewBubble = null;
		}
	}

	//the main function about bubble
	private void addBubble(GeoPoint point) {
		dimissbubble();
		//if there isn't any bubble on the screen enter
		if (viewBubble == null) {

			parentBubble = (ViewGroup) mapView.getParent();
			//We inflate the view with the bubble
			viewBubble = getLayoutInflater().inflate(R.layout.map_tag_bubble,
					parentBubble, false);

			//to position the bubble over the map. The -128 and -150 are the offset.
			MapView.LayoutParams mvlp = new MapView.LayoutParams(
					MapView.LayoutParams.WRAP_CONTENT,
					MapView.LayoutParams.WRAP_CONTENT, geo, -128, -150,
					MapView.LayoutParams.LEFT);



			LinearLayout f = (LinearLayout) viewBubble;
			//Fill the text
			((TextView) f.findViewById(R.id.tag_title_textview))
			.setText(item.getTitle());
			((TextView) f.findViewById(R.id.tag_last_seen_textview))
			.setText(item.getSnippet());


			//And the event.
			viewBubble.setOnClickListener(new OnClickListener() {

				//When we touch the bubble it is removed. And make null viewBubble to reuse it.
				public void onClick(View v) {
					System.out.println("click");
					r.getRoutePOIs().get(selectedPOIIndex).getId();
					Intent i = new Intent();
					i.setClass(getApplicationContext(), POIDetailActivity.class);
					
					i.putExtra("clave3", "hola");
					startActivity(i);
					
					mapView.removeView(viewBubble);
					viewBubble = null;

				}
			});
			//As you see, add in the map.
			mapView.addView(viewBubble, mvlp);
		}
	}

	private class ParallelMapPin extends ItemizedOverlay<OverlayItem> {

		private ArrayList<OverlayItem> locations = new ArrayList<OverlayItem>();



		public ParallelMapPin(Drawable defaultMarker) {
			super(boundCenterBottom(defaultMarker));
			populate();
		}

		public void addPois(Drawable defaultMarker, List<POI> pois) {


			for (Iterator<POI> iterator = pois.iterator(); iterator.hasNext();) {
				POI poi = (POI) iterator.next();
				locations.add(new OverlayItem(new GeoPoint(poi.getIntLatitude(), poi.getIntLongitude()), poi.getName(), poi.getDescription()));
				populate();

			}
		}

		@Override
		public boolean onTap(GeoPoint p, MapView mapView) {
			dimissbubble();
			return super.onTap(p, mapView);
		}


		@Override
		protected boolean onTap(int index) {

			item = getItem(index);
			geo = item.getPoint();
			selectedPOIIndex = index;
			addBubble(geo);  //We call the functtion addbubble passing the position of the item tapped
			return true;
		}


		@Override
		public void draw(Canvas canvas, MapView mapView, boolean shadow) {
			super.draw(canvas, mapView, shadow);
		}

		@Override
		protected OverlayItem createItem(int i) {
			return locations.get(i);
		}

		@Override
		public int size() {
			return locations.size();
		}


	}


}
