package it.poliba.cmg.sscentry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.eclipse.rdf4j.model.Model;

import java.io.File;
import java.util.HashMap;

// Main activity class, to manage all the buttons and actions within the application
public class MainActivity extends AppCompatActivity {

    public static Model model;
    private static final String FILE_NAME = RDFManager.filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        Button button1 = findViewById(R.id.button1);
        button1.setText("Submit UCLA Questionnaire");
        Button button2 = findViewById(R.id.button2);
        button2.setText("Submit IIEF5 Questionnaire");
        Button button3 = findViewById(R.id.button3);
        button3.setText("Submit WPAI Questionnaire");
        Button button4 = findViewById(R.id.button4);
        button4.setText("Run query 1");
        Button button5 = findViewById(R.id.button5);
        button5.setText("Run query 2");

    button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Check if the file exists
            if (!fileExists()) {
                // If the file doesn't exist, create and save a new file
                createAndSaveRDF();
            }
            // Once file exists, read the file and update the model
            model = RDFManager.readRDFFromFile(new File(getFilesDir(), FILE_NAME));
            if (model == null) {
              Toast.makeText(getBaseContext(), "Failed to read RDF", Toast.LENGTH_LONG).show();
            }else{
                // Answers simulation
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
                map.put("ans31", "0");
                map.put("ans32", "0");
                map.put("ans33", "1");
                map.put("ans34", "0");

                model = RDFManager.addAnswersUCLA(map, model);
                Toast.makeText(getBaseContext(), "Model updated successfully", Toast.LENGTH_LONG).show();

                boolean saved = RDFManager.saveRDFToFile(new File(getFilesDir(), FILE_NAME), model);
                if (saved) {
                  Toast.makeText(getBaseContext(), "RDF saved successfully", Toast.LENGTH_LONG).show();
                } else {
                  Toast.makeText(getBaseContext(), "Failed to save RDF", Toast.LENGTH_LONG).show();
                }
            }
        }
    });

    button2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              // Check if the file exists
              if (!fileExists()) {
                  // If the file doesn't exist, create and save a new file
                  createAndSaveRDF();
              }
              // Once file exists, read the file and update the model
              model = RDFManager.readRDFFromFile(new File(getFilesDir(), FILE_NAME));
              if (model == null) {
                  Toast.makeText(getBaseContext(), "Failed to read RDF", Toast.LENGTH_LONG).show();
              }else{
                  // Answers simulation
                  HashMap<String, String> map = new HashMap<>();
                  map.put("ans1", "1");
                  map.put("ans2", "0");
                  map.put("ans3", "1");
                  map.put("ans4", "1");
                  map.put("ans5", "0");

                  model = RDFManager.addAnswersIIEF5(map, model);
                  Toast.makeText(getBaseContext(), "Model updated successfully", Toast.LENGTH_LONG).show();

                  boolean saved = RDFManager.saveRDFToFile(new File(getFilesDir(), FILE_NAME), model);
                  if (saved) {
                      Toast.makeText(getBaseContext(), "RDF saved successfully", Toast.LENGTH_LONG).show();
                  } else {
                      Toast.makeText(getBaseContext(), "Failed to save RDF", Toast.LENGTH_LONG).show();
                  }
              }
          }
      });


    button3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Check if the file exists
            if (!fileExists()) {
                // If the file doesn't exist, create and save a new file
                createAndSaveRDF();
            }
            // Once file exists, read the file and update the model
            model = RDFManager.readRDFFromFile(new File(getFilesDir(), FILE_NAME));
            if (model == null) {
                Toast.makeText(getBaseContext(), "Failed to read RDF", Toast.LENGTH_LONG).show();
            }else{
                // Answers simulation
                HashMap<String, String> map = new HashMap<>();
                map.put("ans1", "Yes");
                map.put("ans2", "20");
                map.put("ans3", "24");
                map.put("ans4", "29");
                map.put("ans5", "3");
                map.put("ans6", "8");

                model = RDFManager.addAnswersWPAI(map, model);
                Toast.makeText(getBaseContext(), "Model updated successfully", Toast.LENGTH_LONG).show();

                boolean saved = RDFManager.saveRDFToFile(new File(getFilesDir(), FILE_NAME), model);
                if (saved) {
                    Toast.makeText(getBaseContext(), "RDF saved successfully", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getBaseContext(), "Failed to save RDF", Toast.LENGTH_LONG).show();
                }
            }
        }
    });

    button4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String queryType = "1";
            Intent intent = new Intent(MainActivity.this, QueryResultVisualization.class);
            intent.putExtra("type", queryType);
            startActivity(intent);

        }
    });

    button5.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String queryType = "2";
            Intent intent = new Intent(MainActivity.this, QueryResultVisualization.class);
            intent.putExtra("type", queryType);
            startActivity(intent);

        }
    });
}

    // Check if the file exists
    private boolean fileExists() {
        File file = new File(getFilesDir(), FILE_NAME);
        return file.exists();
    }

    // Create and save a new file with a model containing only questions and possible answers for each type of questionnaire
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
