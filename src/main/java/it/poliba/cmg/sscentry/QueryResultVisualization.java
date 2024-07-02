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

        Model model = RDFManager.readRDFFromFile(new File(getFilesDir(), RDFManager.filename));

        String subject = null;
        IRI object = factory.createIRI(RDFManager.rdf, "Sequence_UCLA_1");
        IRI predicate = factory.createIRI(RDFManager.cmg_vocabulary, "sequence");

        Model newModel = getQueryResult(model, subject, predicate, object);
        textView.setText(RDFManager.printModel(newModel));
    }

    public Model getQueryResult(Model model, String subject, IRI predicate, IRI object){
        Model modelFiltered = model.filter(null, predicate, object);
        return modelFiltered;
    }
}