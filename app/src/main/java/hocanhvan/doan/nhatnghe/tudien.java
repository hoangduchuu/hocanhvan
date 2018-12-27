package hocanhvan.doan.nhatnghe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class tudien extends Activity {
	
	ImageView giupdo,menuchinh;
	Button tracuu;
	EditText formtracuu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tudien);
		
		
		tracuu=(Button)findViewById(R.id.buttontracuu);
		formtracuu=(EditText)findViewById(R.id.formtracuu);
		
		giupdo=(ImageView)findViewById(R.id.hinhgiupdo);
		menuchinh=(ImageView)findViewById(R.id.hinhbackmenu);
		
		
		
		tracuu.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String tukhoa=formtracuu.getText().toString();
				
				finish();
				Intent i=new Intent(getApplicationContext(),infotracuu.class);
				i.putExtra("tukhoa", tukhoa);
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
