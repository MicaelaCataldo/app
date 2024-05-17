package it.poliba.cmg.sscentry;

import static org.eclipse.rdf4j.model.util.Statements.statement;
import static org.eclipse.rdf4j.model.util.Values.iri;
import static org.eclipse.rdf4j.model.util.Values.literal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Literal;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.vocabulary.RDF4J.*;

public class MainActivity extends AppCompatActivity {
    String disco = "http://rdf-vocabulary.ddialliance.org/discovery";
    IRI bob = iri("http://example.org/bob");
    IRI nameProp = iri("http://example.org/name");
    Literal bobsName = literal("Bob");
    Literal bobsAge = literal(42);

    Statement st = statement(bob, nameProp, bobsName, null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}