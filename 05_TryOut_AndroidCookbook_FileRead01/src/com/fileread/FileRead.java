package com.fileread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FileRead extends Activity {
    private TextView fileTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);
    	InputStreamReader is = new InputStreamReader(this.getResources().openRawResource(R.raw.samplefile));
    	BufferedReader reader = new BufferedReader(is);
    	StringBuilder finalText = new StringBuilder();
    	String line;
    	try {
			while ((line = reader.readLine()) != null) {
			    finalText.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

    	fileTextView = (TextView)findViewById(R.id.fileText);
    	fileTextView.setText(finalText.toString());
    }
}