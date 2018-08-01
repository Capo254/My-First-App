package com.example.emobilis.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2 extends AppCompatActivity {

    Button call,share,message,capture,toolkit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        call=findViewById(R.id.button);
        share=findViewById(R.id.button4);
        message=findViewById(R.id.button5);
        capture=findViewById(R.id.button6);
        toolkit=findViewById(R.id.button3);

        call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String phone="0714772735";
                //intents enable you to perform an activity
                Intent afte=new Intent(Intent.ACTION_DIAL, Uri.fromParts(
                        "tel",phone,null));
                startActivity(afte);
            }
        });
        share.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent shareme=new Intent(Intent.ACTION_SEND);
                shareme.setType("plain/text");
                startActivity(Intent.createChooser(shareme,"Share Text"));
            }
        });
        message.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent sms=new Intent(Intent.ACTION_MAIN);
                sms.setType("vnd.android-dir/mms-sms");
                startActivity(sms);
            }
        });
        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent piga=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(piga,0);
            }
        });
        toolkit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent launch=getApplicationContext().getPackageManager()
                        .getLaunchIntentForPackage("com.android.stk");
                if (launch!=null){
                    startActivity(launch);
                }
            }
        });
    }
}
