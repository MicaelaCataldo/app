package it.poliba.cmg.sscentry;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.util.Values;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;

import java.io.OutputStream;

public class RDFManager {

    private static Model model;

    public static String generateRDF() {
        StringBuilder result = new StringBuilder();

        // Define the namespace
        String disco = "http://rdf-vocabulary.ddialliance.org/discovery#";
        String qb = "https://www.w3.org/TR/vocab-data-cube/#";
        String cmg_vocabulary = "http://example.org/cmg_vocabulary#";

        // Create a ValueFactory to create RDF objects
        ValueFactory factory = SimpleValueFactory.getInstance();
        IRI Study = factory.createIRI(disco, "Study");
        IRI Questionnaire = factory.createIRI(disco, "Questionnaire");
        IRI Question = factory.createIRI(disco, "Question");
        IRI LogicalDataset = factory.createIRI(disco, "LogicalDataset");
        IRI Dataset = factory.createIRI(qb, "Dataset");
        IRI Observation = factory.createIRI(qb, "Observation");
        IRI Variable = factory.createIRI(disco, "Variable");
        IRI ConceptScheme = factory.createIRI(disco, "ConceptScheme");
        IRI Concept = factory.createIRI(disco, "Concept");
        IRI RepresentedVariable = factory.createIRI(disco, "RepresentedVariable");

        // Create IRIs for different concepts

        // Create the relationships (predicates)
        IRI question = factory.createIRI(disco, "question");
        IRI questionText = factory.createIRI(disco, "questionText");
        IRI hasTopConcept = factory.createIRI(disco, "hasTopConcept");
        IRI basedOn = factory.createIRI(disco, "basedOn");
        IRI representation = factory.createIRI(disco, "representation");
        IRI instrument = factory.createIRI(disco, "instrument");
        IRI aggregation = factory.createIRI(disco, "aggregation");
        IRI dataset = factory.createIRI(qb, "dataset");
        IRI inputVariable = factory.createIRI(qb, "inputVariable");
        IRI section = factory.createIRI(cmg_vocabulary, "section");
        IRI hasDate = factory.createIRI(cmg_vocabulary, "hasDate");
        IRI hasScore = factory.createIRI(cmg_vocabulary, "hasScore");



        IRI QuestionnaireUCLA = factory.createIRI(cmg_vocabulary, "QuestionnaireUCLA");
        IRI Question1 = factory.createIRI(cmg_vocabulary, "Question1");
        IRI Variable1 = factory.createIRI(cmg_vocabulary, "Variable1");
        IRI ConceptScheme1 = factory.createIRI(cmg_vocabulary, "ConceptScheme1");
        IRI Concept1_1 = factory.createIRI(cmg_vocabulary, "Concept1_1");
        IRI Concept1_2 = factory.createIRI(cmg_vocabulary, "Concept1_2");
        IRI Concept1_3 = factory.createIRI(cmg_vocabulary, "Concept1_3");
        IRI Concept1_4 = factory.createIRI(cmg_vocabulary, "Concept1_4");
        IRI RepresentedVariable1 = factory.createIRI(cmg_vocabulary, "RepresentedVariable1");
        IRI question1 = factory.createIRI(cmg_vocabulary, "question1");
        IRI hasScore1 = factory.createIRI(cmg_vocabulary, "hasScore1");

        // Create the statements using ModelBuilder
        ModelBuilder builder = new ModelBuilder();

        builder.add(Study, instrument, QuestionnaireUCLA);
        builder.add(QuestionnaireUCLA, RDF.TYPE, Questionnaire);
        builder.add(Question1, RDF.TYPE, Question);
        builder.add(question1, RDF.TYPE, question);
        builder.add(QuestionnaireUCLA, question1, Question1);
        builder.add(question1, section, Values.literal("Reflux"));
        builder.add(Question1, questionText, Values.literal("In the past 1 week, how often did you have difficulty swallowing solid food?")); // guardalo nel grafo Prezi
        builder.add(Variable1, question1, Question1);
        builder.add(Variable1, RDF.TYPE, Variable);
        builder.add(RepresentedVariable1, RDF.TYPE, RepresentedVariable);
        builder.add(Variable1, basedOn, RepresentedVariable1);
        builder.add(ConceptScheme1, RDF.TYPE, ConceptScheme);
        builder.add(RepresentedVariable1, representation, ConceptScheme1);
        builder.add(Concept1_1, RDF.TYPE, Concept);
        builder.add(Concept1_2, RDF.TYPE, Concept);
        builder.add(Concept1_3, RDF.TYPE, Concept);
        builder.add(Concept1_4, RDF.TYPE, Concept);
        builder.add(ConceptScheme1, hasTopConcept, Concept1_1);
        builder.add(ConceptScheme1, hasTopConcept, Concept1_2);
        builder.add(ConceptScheme1, hasTopConcept, Concept1_3);
        builder.add(ConceptScheme1, hasTopConcept, Concept1_4);
        builder.add(hasScore1, RDF.TYPE, hasScore);
        builder.add(hasTopConcept, hasScore1, Values.literal("Score"));


        // Build the model
        model = builder.build();

        // Convert statements to readable format
        model.forEach(statement -> {
            String subject = statement.getSubject().stringValue();
            String predicate = statement.getPredicate().stringValue();
            String object = statement.getObject().stringValue();

            // Extract the local name (the part after the last '#')
            String subjectName = subject.substring(subject.lastIndexOf('#') + 1);
            String predicateName = predicate.substring(predicate.lastIndexOf('#') + 1);
            String objectName = object.substring(object.lastIndexOf('#') + 1);

            result.append(String.format("%s %s %s.\n", subjectName, predicateName, objectName));
        });

        return result.toString();
    }

    public static boolean saveRDFToFile(Uri uri, Context context) {
        try {
            OutputStream outputStream = context.getContentResolver().openOutputStream(uri);
            if (outputStream != null) {
                Rio.write(model, outputStream, RDFFormat.TURTLE);
                outputStream.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
