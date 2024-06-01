package it.poliba.cmg.sscentry;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.eclipse.rdf4j.model.Model;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    public static Model model;
    private static final String FILE_NAME = "questionnaire.ttl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        // Check if the file exists
        if (fileExists()) {
            // If the file exists, read the file
            model = RDFManager.readRDFFromFile(new File(getFilesDir(), FILE_NAME));
            if (model == null) {
                Toast.makeText(this, "Failed to read RDF", Toast.LENGTH_LONG).show();
            }else{
                textView.setText(RDFManager.printModel(model));
                // Your answers logic
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
                Toast.makeText(this, "Model updated successfully", Toast.LENGTH_LONG).show();
                textView.setText(RDFManager.printModel(model));
                boolean saved = RDFManager.saveRDFToFile(new File(getFilesDir(), FILE_NAME), model);
                if (saved) {
                    Toast.makeText(this, "RDF saved successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Failed to save RDF", Toast.LENGTH_LONG).show();
                }
            }
        } else {
            // If the file does not exist, create a new file
            createAndSaveRDF();
        }
    }

    private boolean fileExists() {
        File file = new File(getFilesDir(), FILE_NAME);
        return file.exists();
    }

    private void createAndSaveRDF() {
        model = RDFManager.generateRDF();
        boolean saved = RDFManager.saveRDFToFile(new File(getFilesDir(), FILE_NAME), model);
        if (saved) {
            Toast.makeText(this, "RDF saved successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Failed to save RDF", Toast.LENGTH_LONG).show();
        }
    }
}
