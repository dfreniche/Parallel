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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageButton buttonRoute;
	ImageButton buttonCustomRoute;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // link buttons
        
        
        
        this.buttonRoute = (ImageButton)findViewById(R.id.imageButtonRoute);
        this.buttonCustomRoute = (ImageButton)findViewById(R.id.imageButtonCustomRoute);
        
        this.buttonRoute.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Log.d("", "Launch Routes");
				Intent i = new Intent(MainActivity.this, RoutesListActivity.class);
				i.putExtra("clave1", "Hello!");
				i.putExtra("clave2", 10);
				i.putExtra("clave3", "hola");
				startActivity(i);
			}
        	
        });
        
        this.buttonCustomRoute.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Log.d("", "Launch Custom Routes");
				Intent i = new Intent(MainActivity.this, CustomRouteActivity.class);
				
				startActivity(i);
			}
        	
        });
        
    }
    
    
    

    @Override
	protected void onResume() {
		
		super.onResume();
		
		Toast.makeText(this, "Welcome to the exciting world of CCCB", Toast.LENGTH_LONG).show();
	}




	// Menu Stuff
    // Called first time user clicks on the menu button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
   
 // Called when an options item is clicked
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) { 
    		case R.id.menu_custom_route: Log.d("menu", "option 1");
    	}
    
    	return true;
    }


    
}
