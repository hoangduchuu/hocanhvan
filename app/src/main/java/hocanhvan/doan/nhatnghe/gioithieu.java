package hocanhvan.doan.nhatnghe;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class gioithieu extends Activity {

	TextView gioithieudungdung,baymau;
	ImageView giupdo,menuchinh;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gioithieu);
		
		giupdo=(ImageView)findViewById(R.id.hinhgiupdo);
		menuchinh=(ImageView)findViewById(R.id.hinhbackmenu);
		baymau=(TextView)findViewById(R.id.baymau);
		
		gioithieudungdung=(TextView)findViewById(R.id.gioithieudungdung);
		Typeface face=Typeface.createFromAsset(this.getAssets(), "Blazed.ttf");
		gioithieudungdung.setTypeface(face);
		
		
		int[] mausac={Color.RED,Color.GREEN,Color.BLUE,Color.MAGENTA};
	      int dem=0;
	      SpannableString text5=new SpannableString("5. Học thông qua YouTube");
	      text5.setSpan(new UnderlineSpan(), 12, 14, 0);
	      for(int i=0;i<text5.length();i++)
	      {
	    	  text5.setSpan(new RelativeSizeSpan(0.3f+(0.1f*i)),i,i+1,0);
	    	  text5.setSpan(new ForegroundColorSpan(mausac[dem]),i,i+1,0);
	    	  dem++;
	    	  if(dem==mausac.length)
	    	  dem=0;
	    	  
	      }
	      baymau.setText(text5,BufferType.SPANNABLE);
		
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
