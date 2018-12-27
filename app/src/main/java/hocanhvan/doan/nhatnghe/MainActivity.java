package hocanhvan.doan.nhatnghe;

import hocanhvan.doan.nhatnghe.DynamicLayoutViewGroup;
import hocanhvan.doan.nhatnghe.R;
import hocanhvan.doan.nhatnghe.MainActivity.SampleLayoutModel;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.Toast;
import android.media.MediaPlayer;



	public class MainActivity extends Activity implements DynamicLayoutViewGroup.ItemSelectedListener {

		protected static Configuration cfg;
		MediaPlayer nhacnen;
		/** Called when the activity is first created. */
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);

			// Find the DynamicLayoutViewGroup
			DynamicLayoutViewGroup dlvg = (DynamicLayoutViewGroup) findViewById(R.id.menugroup);

			// Set ourself as a selection listener, useful if we are using
			// this as a fancy menu
			dlvg.setOnSelectionListener(this);

			// Set a new layout model. To use the default LayoutModel, simply
			// comment out the following line
			 dlvg.setLayoutModel(new SampleLayoutModel());
			 nhacnen=MediaPlayer.create(MainActivity.this, R.raw.moichonok);
			nhacnen.start();
		}

	protected void onPause(){
		super.onPause();
		nhacnen.release();
		finish();
	}
	
	public class SampleLayoutModel implements LayoutModel {
		int viewheight;
		int viewwidth;

		
		int order[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

		
		Rect r[];
		
		Rect badRect = new Rect(-10, -10, -9, -9);

		public SampleLayoutModel() {
			
			r = new Rect[9];
			for (int i = 0; i < 9; i++) {
				r[i] = new Rect();
			}
		}

		
		public Rect getLayoutRect(int pos, int selected) {
			
			Rect ret;

			
			if ((pos < 9) && (selected < 9)) {
				if (selected != order[0]) {
					int s = 0;
					while (order[s] != selected) {
						s++;
					}
					
					order[s] = order[0];
					order[0] = selected;
				}

				int i = 0;
				while (order[i] != pos) {
					i++;
				}

				ret = r[i];
			} else {
				
				ret = badRect;
			}
			return ret;
		}

		
		public void onSizeChanged(int width, int height, int oldw, int oldh) {
			
			viewheight = height;
			viewwidth = width;

			
			if (height > width) {
				int select_width = (int) (width * .80);
				int select_height = select_width;

				int select_top = (height - select_height) / 2;
				int select_left = (width - select_width) / 2;

				int unselect_height = (int) (select_top * .80);
				int unselect_width = unselect_height;
				int topbottom_margin = (select_top - unselect_height) / 2;
				int spacing = 5;

				if ((unselect_width * 4) > (width - (5 * spacing))) {
				
					spacing = 5;
					unselect_width = (width - (5 * spacing)) / 4;
					unselect_height = unselect_width;
				} else {
					
					spacing = (width - (unselect_width * 4)) / 5;
				}

				r[0].set(select_left, select_top, select_left + select_width, select_top + select_height);
				for (int i = 1; i < 5; i++) {
					int left = spacing + ((i - 1) * (spacing + unselect_width));
					r[i].set(left, topbottom_margin, left + unselect_width, topbottom_margin + unselect_height);
				}
				for (int i = 5; i < 9; i++) {
					int left = spacing + ((i - 5) * (spacing + unselect_width));
					r[i].set(left, height - topbottom_margin - unselect_height, left + unselect_width, height - topbottom_margin);
				}
			} else {
				
				int select_height = (int) (height * .90);
				int select_width = select_height;

				int select_top = (height - select_height) / 2;
				int select_left = (width - select_width) / 2;

				int unselect_height = (int) (select_left * .80);
				int unselect_width = unselect_height;
				int leftright_margin = (select_left - unselect_width) / 2;
				int spacing = 5;

				if ((unselect_height * 4) > (height - (5 * spacing))) {
					
					spacing = 5;
					unselect_height = (height - (5 * spacing)) / 4;
					unselect_width = unselect_height;
				} else {
					
					spacing = (height - (unselect_height * 4)) / 5;
				}

				r[0].set(select_left, select_top, select_left + select_width, select_top + select_height);
				for (int i = 1; i < 5; i++) {
					int top = spacing + ((i - 1) * (spacing + unselect_height));
					r[i].set(leftright_margin, top, leftright_margin + unselect_width, top + unselect_height);
				}
				for (int i = 5; i < 9; i++) {
					int top = spacing + ((i - 5) * (spacing + unselect_height));
					r[i].set(width - leftright_margin - unselect_width, top, width - leftright_margin, top + unselect_height);
				}
			}
		}
	}

	
	public void onItemSelected(int pos, int viewId) {
		//Toast.makeText(this, "Pos " + pos + " viewId " + viewId + " selected", 3000).show();
		
		
		if(pos==0)
		{
			Intent i=new Intent(getApplication(),gioithieu.class);
			startActivity(i);
			
		}
		
		if(pos==1)
		{
			Intent i=new Intent(getApplication(),hocnghe.class);
			startActivity(i);
			
		}
		
		if(pos==2)
		{
			Intent i=new Intent(getApplication(),xemvideo.class);
			startActivity(i);
			
		}
		
		if(pos==3)
		{
			Intent i=new Intent(getApplication(),Ghinho_congviecActivity.class);
			startActivity(i);
			
		}
		
		if(pos==4)
		{
			Intent i=new Intent(getApplication(),vanpham.class);
			startActivity(i);
			
		}
		
		if(pos==5)
		{
			Intent i=new Intent(getApplication(),tudien.class);
			startActivity(i);
			
		}
		
		if(pos==6)
		{
			Intent i=new Intent(getApplication(),elearning.class);
			startActivity(i);
			
		}
		
		if(pos==7)
		{
			Intent i=new Intent(getApplication(),tacgia.class);
			startActivity(i);
			
		}
		
		if(pos==8)
		{
			nhacnen=MediaPlayer.create(MainActivity.this, R.raw.camonthoat);
			nhacnen.start();
			
			Thread bamgio=new Thread(){
				public void run(){
					try{
						sleep(4000);
						
						
					} catch (Exception e){
						
					} finally{
						
						System.exit(0);
						 finish();  
						//Intent activitymoi=
								//new Intent(getApplicationContext(),MainActivity.class);
						//startActivity(activitymoi);
					}
				}
			};
			bamgio.start();
			
			 
		}
		
		
	}

}