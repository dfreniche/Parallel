package org.cccb.parallel;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

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
				Log.d("", "hello");
				
			}
        	
        });
        
        this.buttonCustomRoute.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				Log.d("", "hello");
				
			}
        	
        });
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
