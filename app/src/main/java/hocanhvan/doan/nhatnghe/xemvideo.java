package hocanhvan.doan.nhatnghe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class xemvideo extends Activity {
	TextView chonvideo;
	ImageView giupdo,menuchinh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xemvideo);
		
		chonvideo=(TextView)findViewById(R.id.videochon);
		giupdo=(ImageView)findViewById(R.id.hinhgiupdo);
		menuchinh=(ImageView)findViewById(R.id.hinhbackmenu);
		
		chonvideo.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i=new Intent(getApplication(),playvideo.class);
				startActivity(i);
				
			}
		});
		
		menuchinh.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				Intent i=new Intent(getApplicationContext(),MainActivity.class);
				startActivity(i);
				
			}
		});
		
	}
	
	

}
