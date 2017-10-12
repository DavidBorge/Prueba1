package com.example.david.prueba1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Atributos
    public final static String EXTRA_MESSAGE = "com.example.prueba1.MESSAGE";  //For the next activity to query the extra data, you should define the key for your intent's extra using a public constant. It's generally a good practice to define keys for intent extras using your app's package name as a prefix. This ensures the keys are unique, in case your app interacts with other apps.

    //Métodos
    @Override
    protected void onCreate(Bundle savedInstanceState) {  //onCreate de la actividad principal es el primer método que ejecuta el sistema cuando el usuario pulsa el icono de la aplicación en la pantalla de inicio del launcher (Ver AndroidManifest.xml).
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //Set the user interface layout for this Activity. The layout file is defined in the project res/layout/main_activity.xml file
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Mis métodos

    //Llamado cuando el usuario hace clic en el botón. Si esté método no está, aparece el botón Enviar pero sólo como un View de la interfaz de ususario, al hacer clic en él, la aplicación se detiene.
    public void sendMessage(View view) {  //Un objeto de tipo View es el componente básico para crear componentes en la interfaz de usuario. En este caso es el botón de enviar
        Intent intent = new Intent(this, DisplayMessageActivity.class);  //"Intenta" abrir una nueva Actividad (clase) llamada DisplayMessageActivity
        EditText campoMensaje = (EditText) findViewById(R.id.edit_message);  //Recoge el texto introducido por el usuario en el campo de texto llamado edit_message
        String message = campoMensaje.getText().toString();  //Pasa a String el texto recogido en el paso anterior y lo mete en una variable local llamada message de tipo String
        intent.putExtra(EXTRA_MESSAGE, message);  //Guarda el mensaje dentro del intent con el método putExtra. El primer argumento es el nombre (key) del parámetro (ver arriba)
        startActivity(intent);  //Abrir una instancia de la actividad DisplayMessageActivity con el objeto intent
    }

}
