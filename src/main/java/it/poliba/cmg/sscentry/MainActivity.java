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
    public static Model model;
    public static Uri uri;

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
                        uri = result.getData().getData();
                        if (uri != null) {
                            // Execute the RDF manager and get the result
                            model = RDFManager.generateRDF();
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
                        uri = result.getData().getData();
                        if (uri != null) {
                            model = RDFManager.readRDFFromFile(uri, this);
                            if (model != null) {
                                Toast.makeText(this, "RDF read successfully", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(this, "Failed to read RDF", Toast.LENGTH_LONG).show();
                                requestCreateDocument();
                            }
                        }
                    } else {
                        Toast.makeText(this, "Permission denied to read from external storage", Toast.LENGTH_LONG).show();
                    }
                });

        requestOpenDocument();

        String ans1 = "1";
        String ans2 = "0";
        String ans3 = "1";
        String ans4 = "0";
        String ans5 = "1";
        String ans6 = "0";
        String ans7 = "1";
        String ans8 = "0";
        String ans9 = "1";
        String ans10 = "0";
        String ans11 = "1";
        String ans12 = "0";
        String ans13 = "1";
        String ans14 = "0";
        String ans15 = "1";
        String ans16 = "0";
        String ans17 = "1";
        String ans18 = "0";
        String ans19 = "1";
        String ans20 = "0";
        String ans21 = "1";
        String ans22 = "0";
        String ans23 = "1";
        String ans24 = "0";
        String ans25 = "1";
        String ans26 = "0";
        String ans27 = "1";
        String ans28 = "0";
        String ans29 = "1";
        String ans30 = "0";
        String ans31 = "1";
        String ans32 = "0";
        String ans33 = "1";
        String ans34 = "0";
        model = RDFManager.addAnswersUCLA(ans1, ans2, ans3, ans4, ans5, ans6, ans7, ans8, ans9, ans10, ans11, ans12,
                ans13, ans14, ans15, ans16, ans17, ans18, ans19, ans20, ans21, ans22, ans23, ans24, ans25, ans26,
                ans27, ans28, ans29, ans30, ans31, ans32, ans33, ans34, model);

        textView.setText(RDFManager.printModel(model));
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