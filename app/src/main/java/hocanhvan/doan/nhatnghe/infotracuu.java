package hocanhvan.doan.nhatnghe;

import java.sql.SQLException;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class infotracuu extends Activity{
	Button quaylai;
	TextView hienketqua,tukhoa1;
	private DataBaseHelper myDbHelper;
	private ArrayList<String> arraywork;
	private ArrayAdapter<String> arrayadapter;
	private ListView list;
	private String TAG="mysqllite";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.infotracuu);
		
		quaylai=(Button)findViewById(R.id.buttonquaylaicua);
		quaylai.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				Intent i=new Intent(getApplicationContext(),tudien.class);
				startActivity(i);
			}
		});
		hienketqua=(TextView)findViewById(R.id.hienketqua);
		tukhoa1=(TextView)findViewById(R.id.tukhoa);
	
		Intent i = getIntent();
		String tukhoa = i.getStringExtra("tukhoa");
		String tieude="Từ tra cứu: "+tukhoa;
		tukhoa1.setText(tieude);
		
		
		arraywork=new ArrayList<String>();
	     arrayadapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,arraywork);
	     
	     
	     myDbHelper = new DataBaseHelper(this);
	        //mo csdl
	    	try{
	    		myDbHelper.checkAndCopyDatabase();
	    		myDbHelper.openDataBase();
	    	}catch(SQLException sqle){
	    		Log.d(TAG, "database error!");
	    	}
	    	
	    	try {
				//Cursor c = myDbHelper.QueryData("select nghia from tudien where tukhoa="+tukhoa+"");
	    		Cursor c = myDbHelper.QueryData("select nghia from tudien where tukhoa='"+tukhoa+"'");
				if(c!=null){
		    		if  (c.moveToFirst()) {
			    		
			    			String str = c.getString(c.getColumnIndex("nghia"));
			    			
			    			hienketqua.setText(str);
			    		
		    		}
		    		arrayadapter.notifyDataSetChanged();
		    	}
			} catch (SQLException e) {
				Log.d(TAG, "Query error!");
			}
	    	
	    	
		
	}
	
	

}
