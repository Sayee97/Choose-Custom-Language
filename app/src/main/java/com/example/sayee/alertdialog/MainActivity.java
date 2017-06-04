package com.example.sayee.alertdialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.text);

        sharedPreferences  =this.getSharedPreferences("com.example.sayee.alertdialog", Context.MODE_PRIVATE);
    }
    public void lang(View v){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Choose language")
                .setMessage("You want Spanish or German")
                .setPositiveButton("Spanish", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        sharedPreferences.edit().putString("LANG1","Spanish").apply();
tv.setText(sharedPreferences.getString("LANG1","DEF"));
                    }
                })
                .setNegativeButton("German", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        sharedPreferences.edit().putString("LANG2","German").apply();
                        tv.setText(sharedPreferences.getString("LANG2","DEFlkg"));
                    }
                }).show();


    }
}
