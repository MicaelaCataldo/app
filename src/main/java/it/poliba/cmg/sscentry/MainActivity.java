package it.poliba.cmg.sscentry;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> createDocumentLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        // Execute the RDF manager and get the result
        String rdfOutput = RDFManager.generateRDF();

        // Set the RDF output to the TextView
        textView.setText(rdfOutput);

        // Initialize the ActivityResultLauncher for creating a document
        createDocumentLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Uri uri = result.getData().getData();
                        if (uri != null) {
                            boolean saved = RDFManager.saveRDFToFile(uri, this);
                            if (saved) {
                                Toast.makeText(this, "RDF saved successfully", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(this, "Failed to save RDF", Toast.LENGTH_LONG).show();
                            }
                        }
                    } else {
                        Toast.makeText(this, "Permission denied to write to external storage", Toast.LENGTH_LONG).show();
                    }
                });

        // Request permission to create a document
        requestCreateDocument();
    }

    private void requestCreateDocument() {
        // Prepare the intent for creating a document
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/turtle");
        intent.putExtra(Intent.EXTRA_TITLE, "questionnaire.ttl");

        createDocumentLauncher.launch(intent);
    }
}
