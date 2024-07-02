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

public class QueryResultVisualization extends AppCompatActivity {

    public static ValueFactory factory = SimpleValueFactory.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_result_visualization);
        TextView textView = findViewById(R.id.textView2);
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        Model model = RDFManager.readRDFFromFile(new File(getFilesDir(), RDFManager.filename));

        if(type.equals("1")){
            IRI subject = null;
            IRI predicate = factory.createIRI(RDFManager.cmg_vocabulary, "sequence");
            IRI object = factory.createIRI(RDFManager.rdf, "Sequence_UCLA_1");

            Model newModel = getQueryResult(model, subject, predicate, object);
            textView.setText(RDFManager.printModel(newModel));

        } else if (type.equals("2")){
            IRI subject = null;
            IRI predicate = factory.createIRI(RDFManager.cmg_vocabulary, "dataset");
            IRI object = factory.createIRI(RDFManager.rdf, "Dataset_+2024/07/02_09:33:52");

            Model newModel = getQueryResult(model, subject, predicate, object);
            textView.setText(RDFManager.printModel(newModel));

        } else {
            textView.setText("Nessuna query eseguibile");
        }


    }

    public Model getQueryResult(Model model, IRI subject, IRI predicate, IRI object){
        Model modelFiltered = model.filter(null, predicate, object);
        return modelFiltered;
    }
}