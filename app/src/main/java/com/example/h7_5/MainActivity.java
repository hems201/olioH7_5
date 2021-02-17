package com.example.h7_5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {
    Context context;
    Button btnRead;
    Button btnLoad;
    EditText inputFile;
    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        btnRead = (Button) findViewById(R.id.btnRead);
        btnLoad = (Button) findViewById(R.id.btnLoad);
        inputFile = (EditText) findViewById(R.id.inputFile);
        inputText = (EditText) findViewById(R.id.inputText);

    }
    //write file
    public void readClick (View v){
        try {
            String filename = inputFile.getText().toString();
            OutputStreamWriter osw = new OutputStreamWriter(context.openFileOutput(filename, Context.MODE_PRIVATE));
            String s = inputText.getText().toString();
            osw.write(s);
            osw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    //read file
    public void loadClick (View v) throws IOException {
        String filename = inputFile.getText().toString();
        try {
            InputStream ins = context.openFileInput(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(ins));
            String s;
            String fileContent;
            fileContent = "";
            while ((s=br.readLine()) != null) fileContent = fileContent.concat(s);
            inputText.setText(fileContent);
            ins.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}