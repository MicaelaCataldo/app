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

        // Create the istances (subjects, objects + predicates that will be used as subjects to create the statements) for UCLA Questionnaire
        IRI QuestionnaireUCLA = factory.createIRI(cmg_vocabulary, "QuestionnaireUCLA");
        IRI Question1 = factory.createIRI(cmg_vocabulary, "Question1");
        IRI Variable1 = factory.createIRI(cmg_vocabulary, "Variable1");
        IRI ConceptScheme1 = factory.createIRI(cmg_vocabulary, "ConceptScheme1");
        IRI Concept1 = factory.createIRI(cmg_vocabulary, "No Days");
        IRI Concept2 = factory.createIRI(cmg_vocabulary, "1-2 Days");
        IRI Concept3 = factory.createIRI(cmg_vocabulary, "3-4 Days");
        IRI Concept4 = factory.createIRI(cmg_vocabulary, "5-7 Days");
        IRI RepresentedVariable1 = factory.createIRI(cmg_vocabulary, "RepresentedVariable1");
        IRI question1 = factory.createIRI(cmg_vocabulary, "question1");
        IRI hasScore1 = factory.createIRI(cmg_vocabulary, "hasScore1");
        IRI hasTopConcept1 = factory.createIRI(cmg_vocabulary, "hasTopConcept1");
        IRI hasTopConcept2 = factory.createIRI(cmg_vocabulary, "hasTopConcept2");
        IRI hasTopConcept3 = factory.createIRI(cmg_vocabulary, "hasTopConcept3");
        IRI hasTopConcept4 = factory.createIRI(cmg_vocabulary, "hasTopConcept4");

        // Create the istances for each question
        IRI Question2 = factory.createIRI(cmg_vocabulary, "Question2");
        IRI Variable2 = factory.createIRI(cmg_vocabulary, "Variable2");
        IRI question2 = factory.createIRI(cmg_vocabulary, "question2");
        // ... da completare per le altre domande

        // Create the model builder
        ModelBuilder builder = new ModelBuilder();

        // Create the statements using ModelBuilder
        builder.add(QuestionnaireUCLA, RDF.TYPE, Questionnaire);
        builder.add(Study, instrument, QuestionnaireUCLA);
        builder.add(Question1, RDF.TYPE, Question);
        builder.add(question1, RDF.TYPE, question);
        builder.add(QuestionnaireUCLA, question1, Question1);
        builder.add(question1, section, Values.literal("Reflux"));
        builder.add(Question1, questionText, Values.literal("In the past 1 week, how often did you have difficulty swallowing solid food?")); // guardalo nel grafo Prezi
        builder.add(Variable1, RDF.TYPE, Variable);
        builder.add(Variable1, question1, Question1);
        builder.add(RepresentedVariable1, RDF.TYPE, RepresentedVariable);
        builder.add(Variable1, basedOn, RepresentedVariable1);
        builder.add(ConceptScheme1, RDF.TYPE, ConceptScheme);
        builder.add(RepresentedVariable1, representation, ConceptScheme1);
        builder.add(Concept1, RDF.TYPE, Concept);
        builder.add(Concept2, RDF.TYPE, Concept);
        builder.add(Concept3, RDF.TYPE, Concept);
        builder.add(Concept4, RDF.TYPE, Concept);
        builder.add(hasTopConcept1, RDF.TYPE, hasTopConcept);
        builder.add(hasTopConcept2, RDF.TYPE, hasTopConcept);
        builder.add(hasTopConcept3, RDF.TYPE, hasTopConcept);
        builder.add(hasTopConcept4, RDF.TYPE, hasTopConcept);
        builder.add(ConceptScheme1, hasTopConcept1, Concept1);
        builder.add(ConceptScheme1, hasTopConcept2, Concept2);
        builder.add(ConceptScheme1, hasTopConcept3, Concept3);
        builder.add(ConceptScheme1, hasTopConcept4, Concept4);
        builder.add(hasScore1, RDF.TYPE, hasScore);
        builder.add(hasTopConcept1, hasScore1, Values.literal("0"));
        builder.add(hasTopConcept2, hasScore1, Values.literal("1"));
        builder.add(hasTopConcept3, hasScore1, Values.literal("2"));
        builder.add(hasTopConcept4, hasScore1, Values.literal("3"));

        // Create the statements for each question
        builder.add(Question, RDF.TYPE, Question);
        builder.add(question2, RDF.TYPE, question);
        builder.add(QuestionnaireUCLA, question2, Question2);
        builder.add(question2, section, Values.literal("Reflux"));
        builder.add(Question2, questionText, Values.literal("In the past 1 week, how often did you have an unpleasant stinging or burning sensation in your chest (heartburn)?"));
        builder.add(Variable2, RDF.TYPE, Variable);
        builder.add(Variable2, question2, Question2);
        builder.add(Variable2, basedOn, RepresentedVariable1);
        // ... da completare per le altre domande

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
