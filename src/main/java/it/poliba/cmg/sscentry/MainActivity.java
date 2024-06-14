package it.poliba.cmg.sscentry;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.eclipse.rdf4j.model.Model;

import java.io.File;
import java.util.HashMap;

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
                // Answers simulation. La seguente hasmap contiene una simulazione delle risposte inserite dal paziente in una compilazione del questionario
                HashMap<String, String> map = new HashMap<>();
                map.put("ans1", "1");
                map.put("ans2", "0");
                map.put("ans3", "1");
                map.put("ans4", "1");
                map.put("ans5", "0");
                map.put("ans6", "1");
                map.put("ans7", "2");
                map.put("ans8", "1");
                map.put("ans9", "1");
                map.put("ans10", "3");
                map.put("ans11", "1");
                map.put("ans12", "1");
                map.put("ans13", "0");
                map.put("ans14", "2");
                map.put("ans15", "1");
                map.put("ans16", "1");
                map.put("ans17", "3");
                map.put("ans18", "1");
                map.put("ans19", "1");
                map.put("ans20", "1");
                map.put("ans21", "0");
                map.put("ans22", "1");
                map.put("ans23", "3");
                map.put("ans24", "2");
                map.put("ans25", "1");
                map.put("ans26", "1");
                map.put("ans27", "0");
                map.put("ans28", "1");
                map.put("ans29", "0");
                map.put("ans30", "1");
                map.put("ans31", "1");
                map.put("ans32", "0");
                map.put("ans33", "1");
                map.put("ans34", "0");

                model = RDFManager.addAnswersUCLA(map, model);
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
