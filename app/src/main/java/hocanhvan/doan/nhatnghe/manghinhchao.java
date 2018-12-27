package hocanhvan.doan.nhatnghe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.media.MediaPlayer;

public class manghinhchao extends Activity {
	MediaPlayer nhacnen;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.manghinhchao);
		
		nhacnen=MediaPlayer.create(manghinhchao.this, R.raw.chaomungok);
		nhacnen.start();
		
		Thread bamgio=new Thread(){
			public void run(){
				try{
					sleep(4000);
					
					
				} catch (Exception e){
					
				} finally{
					Intent activitymoi=
							new Intent(getApplicationContext(),MainActivity.class);
					startActivity(activitymoi);
				}
			}
		};
		bamgio.start();
		
	}
	
	protected void onPause(){
		super.onPause();
		nhacnen.release();
		finish();
	}


}
