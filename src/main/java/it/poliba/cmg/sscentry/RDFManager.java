package it.poliba.cmg.sscentry;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Statement;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.util.Values;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.sail.memory.MemoryStore;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;


public class RDFManager {

    public static String generateRDF() {
        StringBuilder result = new StringBuilder();

        // Define the namespace
        String DISCO = "http://rdf-vocabulary.ddialliance.org/discovery#";

        // Create a ValueFactory to create RDF objects
        ValueFactory factory = SimpleValueFactory.getInstance();

        // Create IRIs for different concepts
        IRI study = factory.createIRI(DISCO, "Study");
        IRI questionnaire = factory.createIRI(DISCO, "Questionnaire");
        IRI logicalDataset = factory.createIRI(DISCO, "LogicalDataset");
        IRI dataset = factory.createIRI(DISCO, "Dataset");
        IRI observation = factory.createIRI(DISCO, "Observation");
        IRI question = factory.createIRI(DISCO, "Question");
        IRI variable = factory.createIRI(DISCO, "Variable");
        IRI conceptScheme = factory.createIRI(DISCO, "ConceptScheme");
        IRI concept = factory.createIRI(DISCO, "Concept");

        // Create the relationships (predicates)
        IRI hasQuestion = factory.createIRI(DISCO, "hasQuestion");
        IRI hasVariable = factory.createIRI(DISCO, "hasVariable");
        IRI hasObservation = factory.createIRI(DISCO, "hasObservation");
        IRI hasConcept = factory.createIRI(DISCO, "hasConcept");
        IRI basedOn = factory.createIRI(DISCO, "basedOn");
        IRI responseDomain = factory.createIRI(DISCO, "responseDomain");
        IRI sectionName = factory.createIRI(DISCO, "sectionName");

        // Create the statements using ModelBuilder
        ModelBuilder builder = new ModelBuilder();
        builder.add(questionnaire, hasQuestion, question);
        builder.add(questionnaire, sectionName, Values.literal("sectionNameValue"));
        builder.add(question, hasVariable, variable);
        builder.add(question, responseDomain, conceptScheme);
        builder.add(variable, basedOn, conceptScheme);
        builder.add(conceptScheme, hasConcept, concept);
        builder.add(logicalDataset, hasObservation, observation);
        builder.add(observation, hasVariable, variable);

        // Build the model
        Model model = builder.build();

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
}

        // Append the statements to the result
        //model.forEach(statement -> result.append(statement.toString()).append("\n"));

        //return result.toString();
