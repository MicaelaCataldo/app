package it.poliba.cmg.sscentry;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import org.eclipse.rdf4j.model.Model;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> createDocumentLauncher;
    private ActivityResultLauncher<Intent> openDocumentLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

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

        // Initialize the ActivityResultLauncher for opening a document
        openDocumentLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Uri uri = result.getData().getData();
                        if (uri != null) {
                            Model model = RDFManager.readRDFFromFile(uri, this);
                            if (model != null) {
                                Toast.makeText(this, "RDF read successfully", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(this, "Failed to read RDF", Toast.LENGTH_LONG).show();
                            }
                        }
                    } else {
                        Toast.makeText(this, "Permission denied to read from external storage", Toast.LENGTH_LONG).show();
                    }
                });

        // Request permission to open a document
        requestOpenDocument();

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

    private void requestOpenDocument() {
        // Prepare the intent for opening a document
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/turtle");

        openDocumentLauncher.launch(intent);
    }
}