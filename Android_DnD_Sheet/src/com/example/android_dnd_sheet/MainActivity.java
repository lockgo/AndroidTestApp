package com.example.android_dnd_sheet;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();
		//final Button button = (Button) findViewById(R.id.button1);
		//final TextView textbox1 = (TextView) findViewById(R.id.textView1);

		
		
	}

	private void addListenerOnButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 public void TestFunction(View view) {
	     // Kabloey
		 Toast msg = Toast.makeText(getBaseContext(),
					"You have clicked Button 1", Toast.LENGTH_LONG);
			msg.show();
			TextView textbox1 = (TextView) findViewById(R.id.textView1);
			textbox1.setText("Helloooooo");
			TextView textbox2 = (TextView) findViewById(R.id.textView2);
			textbox2.setText(textbox1.getText());
		 
	 }
	 
	 public void saveTestFunction(View view) 
	 {
		 //File file = new File(Context.getFilesDir(), filename);
		 TextView textbox1 = (TextView) findViewById(R.id.textView1);
		 try { 
		       // catches IOException below
		       final String TESTSTRING = new String("Hello Android");

		       /* We have to use the openFileOutput()-method
		       * the ActivityContext provides, to
		       * protect your file from others and
		       * This is done for security-reasons.
		       * We chose MODE_WORLD_READABLE, because
		       *  we have nothing to hide in our file */             
		       FileOutputStream fOut = openFileOutput("samplefile.txt",
		                                                            MODE_WORLD_READABLE);
		       OutputStreamWriter osw = new OutputStreamWriter(fOut); 

		       // Write the string to the file
		       osw.write(TESTSTRING);

		       /* ensure that everything is
		        * really written out and close */
		       osw.flush();
		       osw.close();

		//Reading the file back...

		       /* We have to use the openFileInput()-method
		        * the ActivityContext provides.
		        * Again for security reasons with
		        * openFileInput(...) */

		        FileInputStream fIn = openFileInput("samplefile.txt");
		        InputStreamReader isr = new InputStreamReader(fIn);

		        /* Prepare a char-Array that will
		         * hold the chars we read back in. */
		        char[] inputBuffer = new char[TESTSTRING.length()];

		        // Fill the Buffer with data from the file
		        isr.read(inputBuffer);

		        // Transform the chars to a String
		        String readString = new String(inputBuffer);

		        // Check if we read back the same chars that we had written out
		        boolean isTheSame = TESTSTRING.equals(readString);

		        Log.i("File Reading stuff", "success = " + isTheSame);
		        textbox1.setText("saved");

		    } 
		 catch (IOException ioe) 
		 {
			 ioe.printStackTrace();
		}
		 
	 }
	 
	 public void loadTestFunction(View view) throws FileNotFoundException 
	 {
		 File filesDir = getFilesDir();
		 //whatthe
		String filename = "samplefile.txt";
		Scanner input = new Scanner(new File(filesDir, filename ));
		TextView textbox2 = (TextView) findViewById(R.id.textView2);
		textbox2.setText(input.next());
	 }

}
