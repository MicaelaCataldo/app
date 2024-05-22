package it.poliba.cmg.sscentry;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView testo= findViewById(R.id.testo);
        testo.setText("Ciao Chiara e Giuseppe");

        RDFmanager.runRDFmanager();


    }
}