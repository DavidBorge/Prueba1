package com.example.david.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    //Métodos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();  //Get the intent send by the MainActivity and assign it to a local variable.
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);  //Extract the message delivered by MyActivity with the getStringExtra() method.
        TextView textView = new TextView(this);  //Crea un objeto tipo View para ver texto. (Recuerda que para recoger texto se usa EditText).
        textView.setTextSize(40);  //Set the text size and message with setText().
        textView.setText(message);  //Establece el texto que tiene que mostrar el objeto textView.

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);  //Add the TextView to the RelativeLayout identified by R.id.content.
        layout.addView(textView);

    }

}
