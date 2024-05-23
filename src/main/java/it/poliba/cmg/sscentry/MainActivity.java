package it.poliba.cmg.sscentry;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        // Execute the RDF manager and get the result
        String rdfOutput = RDFManager.generateRDF();

        // Set the RDF output to the TextView
        textView.setText(rdfOutput);
    }
}
