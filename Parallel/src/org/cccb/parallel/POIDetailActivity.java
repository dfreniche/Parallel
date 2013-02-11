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

import org.cccb.parallel.model.POI;
import org.cccb.parallel.net.CCCBServerAPIWrapper;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class POIDetailActivity extends Activity {

	private TextView txtName;
	private TextView txtDescription;
	private TextView txtAddress;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_poidetail);

		txtName = (TextView)findViewById(R.id.txtPoiName);
		txtDescription = (TextView)findViewById(R.id.txtPoiDescription);
		txtAddress = (TextView)findViewById(R.id.txtPoiAddress);

		Intent i = getIntent();
		Integer id = i.getIntExtra("poiid", 0);
		Integer[] params = { id };

		ReadPoiTask rpt = new ReadPoiTask();
		rpt.execute(params);

	}

	private class ReadPoiTask extends AsyncTask<Integer, Void, POI> {

		@Override
		protected POI doInBackground(Integer... params) {
			POI p = (new CCCBServerAPIWrapper()).getPoiWithId(params[0]);
			return p;
		}

		@Override
		protected void onPostExecute(POI p) {

			txtName.setText(p.getName());
			txtDescription.setText(p.getDescription());
			txtAddress.setText(p.getAddress());

			super.onPostExecute(p);
		}



	}

}
