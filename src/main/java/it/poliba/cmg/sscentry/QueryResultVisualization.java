package it.poliba.cmg.sscentry;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

import java.io.File;

// QueryResultVisualization class, to make query on the model and visualize the result
public class QueryResultVisualization extends AppCompatActivity {

    public static ValueFactory factory = SimpleValueFactory.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_result_visualization);
        TextView textView = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");

        // Read the RDF file, uploading the last version of the model
        Model model = RDFManager.readRDFFromFile(new File(getFilesDir(), RDFManager.filename));

        // Execute the "Type 1" query
        if(type.equals("1")){
            IRI subject = null;
            IRI predicate = factory.createIRI(RDFManager.cmg_vocabulary, "sequence");
            IRI object = factory.createIRI(RDFManager.rdf, "Sequence_UCLA_1");

            // Execute the query
            Model newModel = getQueryResult(model, subject, predicate, object);

            // Show the result of the query on the screen
            textView.setText(RDFManager.printModel(newModel));

        } else if (type.equals("2")){
            // Execute the "Type 2" query
            IRI subject = null;
            IRI predicate = factory.createIRI(RDFManager.cmg_vocabulary, "dataset");
            IRI object = factory.createIRI(RDFManager.cmg_vocabulary, "Dataset_2024/07/04_11:44:21");

            // Execute the query
            Model newModel = getQueryResult(model, subject, predicate, object);

            // Show the result of the query on the screen
            textView.setText(RDFManager.printModel(newModel));
        } else {
            textView.setText("No executable query");
        }
    }

    // Execute the query, interpreted as filter from the full model only triples with the given subject, predicate and object.
    // The entity we want to query must be set to null
    public Model getQueryResult(Model model, IRI subject, IRI predicate, IRI object){
        Model modelFiltered = model.filter(null, predicate, object);
        return modelFiltered;
    }
}