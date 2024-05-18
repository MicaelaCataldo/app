package it.poliba.cmg.sscentry;

import static org.eclipse.rdf4j.model.util.Statements.statement;
import static org.eclipse.rdf4j.model.util.Values.iri;
import static org.eclipse.rdf4j.model.util.Values.literal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.DynamicModelFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;



public class MainActivity extends AppCompatActivity {
    // URL del vocabolario RDF
    public static final String DISCO = "http://rdf-vocabulary.ddialliance.org/discovery#";
    // Crea un ValueFactory per creare oggetti RDF
    ValueFactory factory = SimpleValueFactory.getInstance();

    IRI QuestionnaireUCLASCTC = iri(factory, DISCO+"Questionnaire");
    IRI Question1 = iri(factory, DISCO+"Question");
    IRI question = iri(factory, DISCO+"question");
    Statement statement = statement(QuestionnaireUCLASCTC, question,Question1,null);

    DynamicModelFactory dynamicModelFactory = new DynamicModelFactory();
    Model model = dynamicModelFactory.createEmptyModel();

    // add an RDF statement
    model.add(statement);
    // add another RDF statement by simply providing subject, predicate, and object.
    model.add(QuestionnaireUCLASCTC, question, Question1);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}