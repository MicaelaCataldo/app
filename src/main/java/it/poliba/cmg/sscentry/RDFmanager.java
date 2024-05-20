package it.poliba.cmg.sscentry;

import static org.eclipse.rdf4j.model.util.Statements.statement;
import static org.eclipse.rdf4j.model.util.Values.iri;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.DynamicModelFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;

public class RDFmanager {

    public static final String DISCO = "http://rdf-vocabulary.ddialliance.org/discovery#";
    // Crea un ValueFactory per creare oggetti RDF
    ValueFactory factory = SimpleValueFactory.getInstance();

    IRI QuestionnaireUCLASCTC = iri(factory, DISCO+"Questionnaire");
    IRI Question1 = iri(factory, DISCO+"Question");
    IRI question = iri(factory, DISCO+"question");
    Statement stm = statement(QuestionnaireUCLASCTC, question,Question1,null);
    DynamicModelFactory dynamicModelFactory = new DynamicModelFactory();
    Model model = dynamicModelFactory.createEmptyModel();
    model.add(stm);



    // add an RDF statement
    //model.add(statement);
    // add another RDF statement by simply providing subject, predicate, and object.
    //model.add(QuestionnaireUCLASCTC, question, Question1);

}
