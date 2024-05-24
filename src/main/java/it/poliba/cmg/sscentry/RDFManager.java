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

        // Create IRIs for different concepts
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

        // Create the statements using ModelBuilder
        ModelBuilder builder = new ModelBuilder();

        builder.add(Study, instrument, Questionnaire);
        builder.add(Questionnaire, question, Question);
        builder.add(question, section, Values.literal("SectionName"));
        builder.add(Question, questionText, Values.literal("QuestionText")); // guardalo nel grafo Prezi
        builder.add(LogicalDataset, instrument, Questionnaire);
        builder.add(LogicalDataset, aggregation, Dataset);
        builder.add(aggregation, hasDate, Values.literal("TimeStamp"));  // cercalo il tipo di dato adatto + vedi Prezi
        builder.add(Observation, dataset, Dataset);
        builder.add(Observation, inputVariable, Variable);
        builder.add(Variable, question, Question);
        builder.add(Variable, basedOn, RepresentedVariable);
        builder.add(RepresentedVariable, representation, ConceptScheme);
        builder.add(ConceptScheme, hasTopConcept, Concept);
        builder.add(hasTopConcept, hasDate, Values.literal("Score"));

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
