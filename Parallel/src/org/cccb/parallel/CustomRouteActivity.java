package org.cccb.parallel;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class CustomRouteActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_route);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_custom_route, menu);
        return true;
    }

    
}
