package com.reimunotmoe.imeigenerator;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("native-lib");
    }

    final Context mycontext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText txtbox_imei = findViewById(R.id.textbox_imei);
        final Button btn_generate = findViewById(R.id.button_generate);
        final Button btn_clip = findViewById(R.id.button_clip);
        final Button btn_about = findViewById(R.id.button_about);
        final ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        final Context context = getApplicationContext();


        btn_generate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String imei = GenerateIMEI();
                txtbox_imei.setText(imei);
            }
        });

        btn_clip.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ClipData clip = ClipData.newPlainText("", txtbox_imei.getText());
                clipboard.setPrimaryClip(clip);
                Toast toast = Toast.makeText(context, R.string.toast_cliped, Toast.LENGTH_SHORT);
                toast.show();
            }
        });



        btn_about.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        mycontext);

                // set title
                alertDialogBuilder.setTitle(R.string.btn_about);

                // set dialog message
                alertDialogBuilder
                        .setMessage(Html.fromHtml(getString(R.string.txt_about)))
                        .setCancelable(true)
                        .setPositiveButton(R.string.btn_gotit, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        })
                        .setNegativeButton(R.string.btn_github, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                String url = "https://github.com/ReimuNotMoe/IMEIGeneratorApp";
                                Intent i = new Intent(Intent.ACTION_VIEW);
                                i.setData(Uri.parse(url));
                                startActivity(i);
                            }
                        });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
    }


    public native String GenerateIMEI();
}
