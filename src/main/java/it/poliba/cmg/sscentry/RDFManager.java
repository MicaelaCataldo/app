package it.poliba.cmg.sscentry;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.Triple;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.impl.SimpleValueFactory;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.model.util.Values;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.HashMap;

public class RDFManager {
    // Define the namespace
    public static final String disco = "http://rdf-vocabulary.ddialliance.org/discovery#";
    public static final String qb = "https://www.w3.org/TR/vocab-data-cube/#";
    public static final String cmg_vocabulary = "http://example.org/cmg_vocabulary#";
    public static final String filename = "questionnaire.ttl";

    // Create a ValueFactory to create RDF objects
    public static ValueFactory factory = SimpleValueFactory.getInstance();
    private static Model model;

    public static Model generateRDF() {
       Model result = questionnaireUCLADefinition();
       return result;
    }

    public static Model questionnaireUCLADefinition(){
        StringBuilder result = new StringBuilder();

        // Create the generic classes that will be instanciated as subjects and objects
        IRI Study = factory.createIRI(disco, "Study");
        IRI Questionnaire = factory.createIRI(disco, "Questionnaire");
        IRI Question = factory.createIRI(disco, "Question");

        IRI Variable = factory.createIRI(disco, "Variable");
        IRI ConceptScheme = factory.createIRI(disco, "ConceptScheme");
        IRI Concept = factory.createIRI(disco, "Concept");
        IRI RepresentedVariable = factory.createIRI(disco, "RepresentedVariable");

        // Create the generic classes that will be instanciated as relationships (predicates)
        IRI question = factory.createIRI(disco, "question");
        IRI questionText = factory.createIRI(disco, "questionText");
        IRI hasTopConcept = factory.createIRI(disco, "hasTopConcept");
        IRI basedOn = factory.createIRI(disco, "basedOn");
        IRI representation = factory.createIRI(disco, "representation");
        IRI instrument = factory.createIRI(disco, "instrument");

        IRI section = factory.createIRI(cmg_vocabulary, "section");

        IRI hasScore = factory.createIRI(cmg_vocabulary, "hasScore");

        // Create the IRI of instances for UCLA Questionnaire
        IRI QuestionnaireUCLA = factory.createIRI(cmg_vocabulary, "QuestionnaireUCLA");

        IRI Question1 = factory.createIRI(cmg_vocabulary, "Question1");
        IRI Variable1 = factory.createIRI(cmg_vocabulary, "Variable1");
        IRI question1 = factory.createIRI(cmg_vocabulary, "question1");
        IRI Question2 = factory.createIRI(cmg_vocabulary, "Question2");
        IRI Variable2 = factory.createIRI(cmg_vocabulary, "Variable2");
        IRI question2 = factory.createIRI(cmg_vocabulary, "question2");
        IRI Question3 = factory.createIRI(cmg_vocabulary, "Question3");
        IRI Variable3 = factory.createIRI(cmg_vocabulary, "Variable3");
        IRI question3 = factory.createIRI(cmg_vocabulary, "question3");
        IRI Question4 = factory.createIRI(cmg_vocabulary, "Question4");
        IRI Variable4 = factory.createIRI(cmg_vocabulary, "Variable4");
        IRI question4 = factory.createIRI(cmg_vocabulary, "question4");
        IRI Question5 = factory.createIRI(cmg_vocabulary, "Question5");
        IRI Variable5 = factory.createIRI(cmg_vocabulary, "Variable5");
        IRI question5 = factory.createIRI(cmg_vocabulary, "question5");
        IRI Question6 = factory.createIRI(cmg_vocabulary, "Question6");
        IRI Variable6 = factory.createIRI(cmg_vocabulary, "Variable6");
        IRI question6 = factory.createIRI(cmg_vocabulary, "question6");
        IRI Question7 = factory.createIRI(cmg_vocabulary, "Question7");
        IRI Variable7 = factory.createIRI(cmg_vocabulary, "Variable7");
        IRI question7 = factory.createIRI(cmg_vocabulary, "question7");
        IRI Question8 = factory.createIRI(cmg_vocabulary, "Question8");
        IRI Variable8 = factory.createIRI(cmg_vocabulary, "Variable8");
        IRI question8 = factory.createIRI(cmg_vocabulary, "question8");
        IRI Question9 = factory.createIRI(cmg_vocabulary, "Question9");
        IRI Variable9 = factory.createIRI(cmg_vocabulary, "Variable9");
        IRI question9 = factory.createIRI(cmg_vocabulary, "question9");
        IRI Question10 = factory.createIRI(cmg_vocabulary, "Question10");
        IRI Variable10 = factory.createIRI(cmg_vocabulary, "Variable10");
        IRI question10 = factory.createIRI(cmg_vocabulary, "question10");
        IRI Question11 = factory.createIRI(cmg_vocabulary, "Question11");
        IRI Variable11 = factory.createIRI(cmg_vocabulary, "Variable11");
        IRI question11 = factory.createIRI(cmg_vocabulary, "question11");
        IRI Question12 = factory.createIRI(cmg_vocabulary, "Question12");
        IRI Variable12 = factory.createIRI(cmg_vocabulary, "Variable12");
        IRI question12 = factory.createIRI(cmg_vocabulary, "question12");
        IRI Question13 = factory.createIRI(cmg_vocabulary, "Question13");
        IRI Variable13 = factory.createIRI(cmg_vocabulary, "Variable13");
        IRI question13 = factory.createIRI(cmg_vocabulary, "question13");
        IRI Question14 = factory.createIRI(cmg_vocabulary, "Question14");
        IRI Variable14 = factory.createIRI(cmg_vocabulary, "Variable14");
        IRI question14 = factory.createIRI(cmg_vocabulary, "question14");
        IRI Question15 = factory.createIRI(cmg_vocabulary, "Question15");
        IRI Variable15 = factory.createIRI(cmg_vocabulary, "Variable15");
        IRI question15 = factory.createIRI(cmg_vocabulary, "question15");
        IRI Question16 = factory.createIRI(cmg_vocabulary, "Question16");
        IRI Variable16 = factory.createIRI(cmg_vocabulary, "Variable16");
        IRI question16 = factory.createIRI(cmg_vocabulary, "question16");
        IRI Question17 = factory.createIRI(cmg_vocabulary, "Question17");
        IRI Variable17 = factory.createIRI(cmg_vocabulary, "Variable17");
        IRI question17 = factory.createIRI(cmg_vocabulary, "question17");
        IRI Question18 = factory.createIRI(cmg_vocabulary, "Question18");
        IRI Variable18 = factory.createIRI(cmg_vocabulary, "Variable18");
        IRI question18 = factory.createIRI(cmg_vocabulary, "question18");
        IRI Question19 = factory.createIRI(cmg_vocabulary, "Question19");
        IRI Variable19 = factory.createIRI(cmg_vocabulary, "Variable19");
        IRI question19 = factory.createIRI(cmg_vocabulary, "question19");
        IRI Question20 = factory.createIRI(cmg_vocabulary, "Question20");
        IRI Variable20 = factory.createIRI(cmg_vocabulary, "Variable20");
        IRI question20 = factory.createIRI(cmg_vocabulary, "question20");
        IRI Question21 = factory.createIRI(cmg_vocabulary, "Question21");
        IRI Variable21 = factory.createIRI(cmg_vocabulary, "Variable21");
        IRI question21 = factory.createIRI(cmg_vocabulary, "question21");
        IRI Question22 = factory.createIRI(cmg_vocabulary, "Question22");
        IRI Variable22 = factory.createIRI(cmg_vocabulary, "Variable22");
        IRI question22 = factory.createIRI(cmg_vocabulary, "question22");
        IRI Question23 = factory.createIRI(cmg_vocabulary, "Question23");
        IRI Variable23 = factory.createIRI(cmg_vocabulary, "Variable23");
        IRI question23 = factory.createIRI(cmg_vocabulary, "question23");
        IRI Question24 = factory.createIRI(cmg_vocabulary, "Question24");
        IRI Variable24 = factory.createIRI(cmg_vocabulary, "Variable24");
        IRI question24 = factory.createIRI(cmg_vocabulary, "question24");
        IRI Question25 = factory.createIRI(cmg_vocabulary, "Question25");
        IRI Variable25 = factory.createIRI(cmg_vocabulary, "Variable25");
        IRI question25 = factory.createIRI(cmg_vocabulary, "question25");
        IRI Question26 = factory.createIRI(cmg_vocabulary, "Question26");
        IRI Variable26 = factory.createIRI(cmg_vocabulary, "Variable26");
        IRI question26 = factory.createIRI(cmg_vocabulary, "question26");
        IRI Question27 = factory.createIRI(cmg_vocabulary, "Question27");
        IRI Variable27 = factory.createIRI(cmg_vocabulary, "Variable27");
        IRI question27 = factory.createIRI(cmg_vocabulary, "question27");
        IRI Question28 = factory.createIRI(cmg_vocabulary, "Question28");
        IRI Variable28 = factory.createIRI(cmg_vocabulary, "Variable28");
        IRI question28 = factory.createIRI(cmg_vocabulary, "question28");
        IRI Question29 = factory.createIRI(cmg_vocabulary, "Question29");
        IRI Variable29 = factory.createIRI(cmg_vocabulary, "Variable29");
        IRI question29 = factory.createIRI(cmg_vocabulary, "question29");
        IRI Question30 = factory.createIRI(cmg_vocabulary, "Question30");
        IRI Variable30 = factory.createIRI(cmg_vocabulary, "Variable30");
        IRI question30 = factory.createIRI(cmg_vocabulary, "question30");
        IRI Question31 = factory.createIRI(cmg_vocabulary, "Question31");
        IRI Variable31 = factory.createIRI(cmg_vocabulary, "Variable31");
        IRI question31 = factory.createIRI(cmg_vocabulary, "question31");
        IRI Question32 = factory.createIRI(cmg_vocabulary, "Question32");
        IRI Variable32 = factory.createIRI(cmg_vocabulary, "Variable32");
        IRI question32 = factory.createIRI(cmg_vocabulary, "question32");
        IRI Question33 = factory.createIRI(cmg_vocabulary, "Question33");
        IRI Variable33 = factory.createIRI(cmg_vocabulary, "Variable33");
        IRI question33 = factory.createIRI(cmg_vocabulary, "question33");
        IRI Question34 = factory.createIRI(cmg_vocabulary, "Question34");
        IRI Variable34 = factory.createIRI(cmg_vocabulary, "Variable34");
        IRI question34 = factory.createIRI(cmg_vocabulary, "question34");

        IRI RepresentedVariable1 = factory.createIRI(cmg_vocabulary, "RepresentedVariable1");
        IRI RepresentedVariable2 = factory.createIRI(cmg_vocabulary, "RepresentedVariable2");

        IRI ConceptScheme1 = factory.createIRI(cmg_vocabulary, "ConceptScheme1");
        IRI ConceptScheme2 = factory.createIRI(cmg_vocabulary, "ConceptScheme2");

        IRI Concept1 = factory.createIRI(cmg_vocabulary, "No Days");
        IRI Concept2 = factory.createIRI(cmg_vocabulary, "1-2 Days");
        IRI Concept3 = factory.createIRI(cmg_vocabulary, "3-4 Days");
        IRI Concept4 = factory.createIRI(cmg_vocabulary, "5-7 Days");
        IRI Concept5 = factory.createIRI(cmg_vocabulary, "Yes");
        IRI Concept6 = factory.createIRI(cmg_vocabulary, "No");

        IRI hasScore1 = factory.createIRI(cmg_vocabulary, "hasScore1");
        IRI hasScore2 = factory.createIRI(cmg_vocabulary, "hasScore2");

        IRI hasTopConcept1 = factory.createIRI(cmg_vocabulary, "hasTopConcept1");
        IRI hasTopConcept2 = factory.createIRI(cmg_vocabulary, "hasTopConcept2");
        IRI hasTopConcept3 = factory.createIRI(cmg_vocabulary, "hasTopConcept3");
        IRI hasTopConcept4 = factory.createIRI(cmg_vocabulary, "hasTopConcept4");

        IRI hasTopConcept5 = factory.createIRI(cmg_vocabulary, "hasTopConcept5");
        IRI hasTopConcept6 = factory.createIRI(cmg_vocabulary, "hasTopConcept6");

        // Create the model builder
        ModelBuilder builder = new ModelBuilder();

        builder.setNamespace("disco", "http://rdf-vocabulary.ddialliance.org/discovery#");
        builder.setNamespace("qb", "https://www.w3.org/TR/vocab-data-cube/#");
        builder.setNamespace("cmg", "http://example.org/cmg_vocabulary#");

        // Create the statements using ModelBuilder
        builder.add(Study, instrument, QuestionnaireUCLA);
        builder.add(QuestionnaireUCLA, RDF.TYPE, Questionnaire);

        // Create the statement <QuestionN a Question> for each Question
        builder.add(Question1, RDF.TYPE, Question);
        builder.add(Question2, RDF.TYPE, Question);
        builder.add(Question3, RDF.TYPE, Question);
        builder.add(Question4, RDF.TYPE, Question);
        builder.add(Question5, RDF.TYPE, Question);
        builder.add(Question6, RDF.TYPE, Question);
        builder.add(Question7, RDF.TYPE, Question);
        builder.add(Question8, RDF.TYPE, Question);
        builder.add(Question9, RDF.TYPE, Question);
        builder.add(Question10, RDF.TYPE, Question);
        builder.add(Question11, RDF.TYPE, Question);
        builder.add(Question12, RDF.TYPE, Question);
        builder.add(Question13, RDF.TYPE, Question);
        builder.add(Question14, RDF.TYPE, Question);
        builder.add(Question15, RDF.TYPE, Question);
        builder.add(Question16, RDF.TYPE, Question);
        builder.add(Question17, RDF.TYPE, Question);
        builder.add(Question18, RDF.TYPE, Question);
        builder.add(Question19, RDF.TYPE, Question);
        builder.add(Question20, RDF.TYPE, Question);
        builder.add(Question21, RDF.TYPE, Question);
        builder.add(Question22, RDF.TYPE, Question);
        builder.add(Question23, RDF.TYPE, Question);
        builder.add(Question24, RDF.TYPE, Question);
        builder.add(Question25, RDF.TYPE, Question);
        builder.add(Question26, RDF.TYPE, Question);
        builder.add(Question27, RDF.TYPE, Question);
        builder.add(Question28, RDF.TYPE, Question);
        builder.add(Question29, RDF.TYPE, Question);
        builder.add(Question30, RDF.TYPE, Question);
        builder.add(Question31, RDF.TYPE, Question);
        builder.add(Question32, RDF.TYPE, Question);
        builder.add(Question33, RDF.TYPE, Question);
        builder.add(Question34, RDF.TYPE, Question);

        // Create the statement <QuestionnaireUCLA questionN QuestionN>  for each Question
        // Create the statement <<QuestionnaireUCLA questionN QuestionN> a question> for each question
        // Create the statement <<QuestionnaireUCLA questionN QuestionN> section SectionName> for each question
        Triple tr_q1 = factory.createTriple(QuestionnaireUCLA, question1, Question1);
        builder.add(tr_q1, RDF.TYPE, question);
        builder.add(tr_q1, section, Values.literal("Reflux"));

        Triple tr_q2 = factory.createTriple(QuestionnaireUCLA, question2, Question2);
        builder.add(tr_q2, RDF.TYPE, question);
        builder.add(tr_q2, section, Values.literal("Reflux"));

        Triple tr_q3 = factory.createTriple(QuestionnaireUCLA, question3, Question3);
        builder.add(tr_q3, RDF.TYPE, question);
        builder.add(tr_q3, section, Values.literal("Reflux"));

        Triple tr_q4 = factory.createTriple(QuestionnaireUCLA, question4, Question4);
        builder.add(tr_q4, RDF.TYPE, question);
        builder.add(tr_q4, section, Values.literal("Reflux"));

        Triple tr_q5 = factory.createTriple(QuestionnaireUCLA, question5, Question5);
        builder.add(tr_q5, RDF.TYPE, question);
        builder.add(tr_q5, section, Values.literal("Reflux"));

        Triple tr_q6 = factory.createTriple(QuestionnaireUCLA, question6, Question6);
        builder.add(tr_q6, RDF.TYPE, question);
        builder.add(tr_q6, section, Values.literal("Reflux"));

        Triple tr_q7 = factory.createTriple(QuestionnaireUCLA, question7, Question7);
        builder.add(tr_q7, RDF.TYPE, question);
        builder.add(tr_q7, section, Values.literal("Reflux"));

        Triple tr_q8 = factory.createTriple(QuestionnaireUCLA, question8, Question8);
        builder.add(tr_q8, RDF.TYPE, question);
        builder.add(tr_q8, section, Values.literal("Reflux"));

        Triple tr_q9 = factory.createTriple(QuestionnaireUCLA, question9, Question9);
        builder.add(tr_q9, RDF.TYPE, question);
        builder.add(tr_q9, section, Values.literal("Distension"));

        Triple tr_q10 = factory.createTriple(QuestionnaireUCLA, question10, Question10);
        builder.add(tr_q10, RDF.TYPE, question);
        builder.add(tr_q10, section, Values.literal("Distension"));

        Triple tr_q11 = factory.createTriple(QuestionnaireUCLA, question11, Question11);
        builder.add(tr_q11, RDF.TYPE, question);
        builder.add(tr_q11, section, Values.literal("Distension"));

        Triple tr_q12 = factory.createTriple(QuestionnaireUCLA, question12, Question12);
        builder.add(tr_q12, RDF.TYPE, question);
        builder.add(tr_q12, section, Values.literal("Distension"));

        Triple tr_q13 = factory.createTriple(QuestionnaireUCLA, question13, Question13);
        builder.add(tr_q13, RDF.TYPE, question);
        builder.add(tr_q13, section, Values.literal("Soilage"));

        Triple tr_q14 = factory.createTriple(QuestionnaireUCLA, question14, Question14);
        builder.add(tr_q14, RDF.TYPE, question);
        builder.add(tr_q14, section, Values.literal("Diarrhea"));

        Triple tr_q15 = factory.createTriple(QuestionnaireUCLA, question15, Question15);
        builder.add(tr_q15, RDF.TYPE, question);
        builder.add(tr_q15, section, Values.literal("Diarrhea"));

        Triple tr_q16 = factory.createTriple(QuestionnaireUCLA, question16, Question16);
        builder.add(tr_q16, RDF.TYPE, question);
        builder.add(tr_q16, section, Values.literal("Social Functioning"));

        Triple tr_q17 = factory.createTriple(QuestionnaireUCLA, question17, Question17);
        builder.add(tr_q17, RDF.TYPE, question);
        builder.add(tr_q17, section, Values.literal("Social Functioning"));

        Triple tr_q18 = factory.createTriple(QuestionnaireUCLA, question18, Question18);
        builder.add(tr_q18, RDF.TYPE, question);
        builder.add(tr_q18, section, Values.literal("Social Functioning"));

        Triple tr_q19 = factory.createTriple(QuestionnaireUCLA, question19, Question19);
        builder.add(tr_q19, RDF.TYPE, question);
        builder.add(tr_q19, section, Values.literal("Social Functioning"));

        Triple tr_q20 = factory.createTriple(QuestionnaireUCLA, question20, Question20);
        builder.add(tr_q20, RDF.TYPE, question);
        builder.add(tr_q20, section, Values.literal("Social Functioning"));

        Triple tr_q21 = factory.createTriple(QuestionnaireUCLA, question21, Question21);
        builder.add(tr_q21, RDF.TYPE, question);
        builder.add(tr_q21, section, Values.literal("Social Functioning"));

        Triple tr_q22 = factory.createTriple(QuestionnaireUCLA, question22, Question22);
        builder.add(tr_q22, RDF.TYPE, question);
        builder.add(tr_q22, section, Values.literal("Emotional Wellbeing"));

        Triple tr_q23 = factory.createTriple(QuestionnaireUCLA, question23, Question23);
        builder.add(tr_q23, RDF.TYPE, question);
        builder.add(tr_q23, section, Values.literal("Emotional Wellbeing"));

        Triple tr_q24 = factory.createTriple(QuestionnaireUCLA, question24, Question24);
        builder.add(tr_q24, RDF.TYPE, question);
        builder.add(tr_q24, section, Values.literal("Emotional Wellbeing"));

        Triple tr_q25 = factory.createTriple(QuestionnaireUCLA, question25, Question25);
        builder.add(tr_q25, RDF.TYPE, question);
        builder.add(tr_q25, section, Values.literal("Emotional Wellbeing"));

        Triple tr_q26 = factory.createTriple(QuestionnaireUCLA, question26, Question26);
        builder.add(tr_q26, RDF.TYPE, question);
        builder.add(tr_q26, section, Values.literal("Emotional Wellbeing"));

        Triple tr_q27 = factory.createTriple(QuestionnaireUCLA, question27, Question27);
        builder.add(tr_q27, RDF.TYPE, question);
        builder.add(tr_q27, section, Values.literal("Emotional Wellbeing"));

        Triple tr_q28 = factory.createTriple(QuestionnaireUCLA, question28, Question28);
        builder.add(tr_q28, RDF.TYPE, question);
        builder.add(tr_q28, section, Values.literal("Emotional Wellbeing"));

        Triple tr_q29 = factory.createTriple(QuestionnaireUCLA, question29, Question29);
        builder.add(tr_q29, RDF.TYPE, question);
        builder.add(tr_q29, section, Values.literal("Emotional Wellbeing"));

        Triple tr_q30 = factory.createTriple(QuestionnaireUCLA, question30, Question30);
        builder.add(tr_q30, RDF.TYPE, question);
        builder.add(tr_q30, section, Values.literal("Emotional Wellbeing"));

        Triple tr_q31 = factory.createTriple(QuestionnaireUCLA, question31, Question31);
        builder.add(tr_q31, RDF.TYPE, question);
        builder.add(tr_q31, section, Values.literal("Constipation"));

        Triple tr_q32 = factory.createTriple(QuestionnaireUCLA, question32, Question32);
        builder.add(tr_q32, RDF.TYPE, question);
        builder.add(tr_q32, section, Values.literal("Constipation"));

        Triple tr_q33 = factory.createTriple(QuestionnaireUCLA, question33, Question33);
        builder.add(tr_q33, RDF.TYPE, question);
        builder.add(tr_q33, section, Values.literal("Constipation"));

        Triple tr_q34 = factory.createTriple(QuestionnaireUCLA, question34, Question34);
        builder.add(tr_q34, RDF.TYPE, question);
        builder.add(tr_q34, section, Values.literal("Constipation"));

        // Add the text of each question (statement <QuestionN questionText Values.literal(TextOfTheQuestion)>)
        builder.add(Question1, questionText, Values.literal("In the past 1 week, how often did you have difficulty swallowing solid food?"));
        builder.add(Question2, questionText, Values.literal("In the past 1 week, how often did you have an unpleasant stinging or burning sensation in your chest (heartburn)?"));
        builder.add(Question3, questionText, Values.literal("In the past 1 week, how often did you have a sensation of bitter or sour fluid coming up from your stomach into your mouth (acid reflux)?"));
        builder.add(Question4, questionText, Values.literal("In the past 1 week, how often did you have heartburn on eating ‘acidic’ foods such as tomatoes & oranges?"));
        builder.add(Question5, questionText, Values.literal("In the past 1 week, how often did you regurgitate (throw up or bring up small amounts of previously eaten food)?"));
        builder.add(Question6, questionText, Values.literal("In the past 1 week, how often did you sleep in a ‘raised’ or an ‘L shaped’ position?"));
        builder.add(Question7, questionText, Values.literal("In the past 1 week, how often did you feel like vomiting or throwing up?"));
        builder.add(Question8, questionText, Values.literal("In the past 1 week, how often did you vomit or throw up?"));
        builder.add(Question9, questionText, Values.literal("In the past 1 week, how often did you feel bloated (a sensation of gas or air in the stomach)?"));
        builder.add(Question10, questionText, Values.literal("In the past 1 week, how often did you notice an increase in your belly, sometimes requiring you to open your belt, pants or shirt?"));
        builder.add(Question11, questionText, Values.literal("In the past 1 week, how often did you feel full after eating a small meal?"));
        builder.add(Question12, questionText, Values.literal("In the past 1 week, how often did you pass excessive gas or flatulence?"));
        builder.add(Question13, questionText, Values.literal("In the past 1 week, how often did you accidentally soil (dirty) your underwear before being able to get to a bathroom?"));
        builder.add(Question14, questionText, Values.literal("In the past 1 week, how often did you have loose stools (diarrhea)?"));
        builder.add(Question15, questionText, Values.literal("In the past 1 week, have you noticed your stools becoming watery?"));
        builder.add(Question16, questionText, Values.literal("In the past 1 week, how often did nausea interfere with your social activities?"));
        builder.add(Question17, questionText, Values.literal("In the past 1 week, how often did vomiting interfere with your social activities?"));
        builder.add(Question18, questionText, Values.literal("In the past 1 week, how often did stomach ache or pain interfere with your social activities?"));
        builder.add(Question19, questionText, Values.literal("In the past 1 week, how often did diarrhea interfere with your social activities?"));
        builder.add(Question20, questionText, Values.literal("In the past 1 week, how often did worry you would accidentally soil your underwear interfere with your social activities?"));
        builder.add(Question21, questionText, Values.literal("In the past 1 week, how often did a bloated sensation interfere with your social activities?"));
        builder.add(Question22, questionText, Values.literal("In the past 1 week, how often did you feel worried or anxious about your bowel problems?"));
        builder.add(Question23, questionText, Values.literal("In the past 1 week, how often did you feel embarrassed because of your bowel symptoms?"));
        builder.add(Question24, questionText, Values.literal("In the past 1 week, how often did you have problems with sexual relations because of your bowel symptoms?"));
        builder.add(Question25, questionText, Values.literal("In the past 1 week, how often did you fear not finding a bathroom?"));
        builder.add(Question26, questionText, Values.literal("In the past 1 week, how often did you feel depressed or discouraged due to your bowel symptoms?"));
        builder.add(Question27, questionText, Values.literal("In the past 1 week, how often did you avoid or delay traveling because of your bowel symptoms?"));
        builder.add(Question28, questionText, Values.literal("In the past 1 week, how often did you feel angry or frustrated as a result of your bowel symptoms?"));
        builder.add(Question29, questionText, Values.literal("In the past 1 week, how often did you have problems with your sleep as a result of your bowel symptoms?"));
        builder.add(Question30, questionText, Values.literal("In the past 1 week, how often did you feel ‘stress’ or an upset mood worsens your bowel symptoms?"));
        builder.add(Question31, questionText, Values.literal("In the past 1 week, have you noticed your stools becoming harder?"));
        builder.add(Question32, questionText, Values.literal("In the past 1 week, how often were you constipated or unable to empty your bowels?"));
        builder.add(Question33, questionText, Values.literal("In the past 1 week, how often did you have hard stools?"));
        builder.add(Question34, questionText, Values.literal("In the past 1 week, how often did you have pain while passing your stools?"));

        // Create the statement <VariableN a Variable> for each Variable
        builder.add(Variable1, RDF.TYPE, Variable);
        builder.add(Variable2, RDF.TYPE, Variable);
        builder.add(Variable3, RDF.TYPE, Variable);
        builder.add(Variable4, RDF.TYPE, Variable);
        builder.add(Variable5, RDF.TYPE, Variable);
        builder.add(Variable6, RDF.TYPE, Variable);
        builder.add(Variable7, RDF.TYPE, Variable);
        builder.add(Variable8, RDF.TYPE, Variable);
        builder.add(Variable9, RDF.TYPE, Variable);
        builder.add(Variable10, RDF.TYPE, Variable);
        builder.add(Variable11, RDF.TYPE, Variable);
        builder.add(Variable12, RDF.TYPE, Variable);
        builder.add(Variable13, RDF.TYPE, Variable);
        builder.add(Variable14, RDF.TYPE, Variable);
        builder.add(Variable15, RDF.TYPE, Variable);
        builder.add(Variable16, RDF.TYPE, Variable);
        builder.add(Variable17, RDF.TYPE, Variable);
        builder.add(Variable18, RDF.TYPE, Variable);
        builder.add(Variable19, RDF.TYPE, Variable);
        builder.add(Variable20, RDF.TYPE, Variable);
        builder.add(Variable21, RDF.TYPE, Variable);
        builder.add(Variable22, RDF.TYPE, Variable);
        builder.add(Variable23, RDF.TYPE, Variable);
        builder.add(Variable24, RDF.TYPE, Variable);
        builder.add(Variable25, RDF.TYPE, Variable);
        builder.add(Variable26, RDF.TYPE, Variable);
        builder.add(Variable27, RDF.TYPE, Variable);
        builder.add(Variable28, RDF.TYPE, Variable);
        builder.add(Variable29, RDF.TYPE, Variable);
        builder.add(Variable30, RDF.TYPE, Variable);
        builder.add(Variable31, RDF.TYPE, Variable);
        builder.add(Variable32, RDF.TYPE, Variable);
        builder.add(Variable33, RDF.TYPE, Variable);
        builder.add(Variable34, RDF.TYPE, Variable);

        // Create the <VariableN questionN QuestionN> statement for each Question
        builder.add(Variable1, question1, Question1);
        builder.add(Variable2, question2, Question2);
        builder.add(Variable3, question3, Question3);
        builder.add(Variable4, question4, Question4);
        builder.add(Variable5, question5, Question5);
        builder.add(Variable6, question6, Question6);
        builder.add(Variable7, question7, Question7);
        builder.add(Variable8, question8, Question8);
        builder.add(Variable9, question9, Question9);
        builder.add(Variable10, question10, Question10);
        builder.add(Variable11, question11, Question11);
        builder.add(Variable12, question12, Question12);
        builder.add(Variable13, question13, Question13);
        builder.add(Variable14, question14, Question14);
        builder.add(Variable15, question15, Question15);
        builder.add(Variable16, question16, Question16);
        builder.add(Variable17, question17, Question17);
        builder.add(Variable18, question18, Question18);
        builder.add(Variable19, question19, Question19);
        builder.add(Variable20, question20, Question20);
        builder.add(Variable21, question21, Question21);
        builder.add(Variable22, question22, Question22);
        builder.add(Variable23, question23, Question23);
        builder.add(Variable24, question24, Question24);
        builder.add(Variable25, question25, Question25);
        builder.add(Variable26, question26, Question26);
        builder.add(Variable27, question27, Question27);
        builder.add(Variable28, question28, Question28);
        builder.add(Variable29, question29, Question29);
        builder.add(Variable30, question30, Question30);
        builder.add(Variable31, question31, Question31);
        builder.add(Variable32, question32, Question32);
        builder.add(Variable33, question33, Question33);
        builder.add(Variable34, question34, Question34);

        // Create the <RepresentedVariableN a RepresentedVariable> statement for each RepresentedVariable
        builder.add(RepresentedVariable1, RDF.TYPE, RepresentedVariable);
        builder.add(RepresentedVariable2, RDF.TYPE, RepresentedVariable);

        // Create the <VariableN basedOn RepresentedVariableM> statement for each Variable
        builder.add(Variable1, basedOn, RepresentedVariable1);
        builder.add(Variable2, basedOn, RepresentedVariable1);
        builder.add(Variable3, basedOn, RepresentedVariable1);
        builder.add(Variable4, basedOn, RepresentedVariable1);
        builder.add(Variable5, basedOn, RepresentedVariable1);
        builder.add(Variable6, basedOn, RepresentedVariable1);
        builder.add(Variable7, basedOn, RepresentedVariable1);
        builder.add(Variable8, basedOn, RepresentedVariable1);
        builder.add(Variable9, basedOn, RepresentedVariable1);
        builder.add(Variable10, basedOn, RepresentedVariable1);
        builder.add(Variable11, basedOn, RepresentedVariable1);
        builder.add(Variable12, basedOn, RepresentedVariable1);
        builder.add(Variable13, basedOn, RepresentedVariable1);
        builder.add(Variable14, basedOn, RepresentedVariable1);
        builder.add(Variable15, basedOn, RepresentedVariable2);
        builder.add(Variable16, basedOn, RepresentedVariable1);
        builder.add(Variable17, basedOn, RepresentedVariable1);
        builder.add(Variable18, basedOn, RepresentedVariable1);
        builder.add(Variable19, basedOn, RepresentedVariable1);
        builder.add(Variable20, basedOn, RepresentedVariable1);
        builder.add(Variable21, basedOn, RepresentedVariable1);
        builder.add(Variable22, basedOn, RepresentedVariable1);
        builder.add(Variable23, basedOn, RepresentedVariable1);
        builder.add(Variable24, basedOn, RepresentedVariable1);
        builder.add(Variable25, basedOn, RepresentedVariable1);
        builder.add(Variable26, basedOn, RepresentedVariable1);
        builder.add(Variable27, basedOn, RepresentedVariable1);
        builder.add(Variable28, basedOn, RepresentedVariable1);
        builder.add(Variable29, basedOn, RepresentedVariable1);
        builder.add(Variable30, basedOn, RepresentedVariable1);
        builder.add(Variable31, basedOn, RepresentedVariable2);
        builder.add(Variable32, basedOn, RepresentedVariable1);
        builder.add(Variable33, basedOn, RepresentedVariable1);
        builder.add(Variable34, basedOn, RepresentedVariable1);

        // Create the <ConceptSchemeN a ConceptScheme> statement for each ConceptScheme
        builder.add(ConceptScheme1, RDF.TYPE, ConceptScheme);
        builder.add(ConceptScheme2, RDF.TYPE, ConceptScheme);

        // Create the <RepresentedVariableN representation ConceptSchemeN> statement for each RepresentedVariable
        builder.add(RepresentedVariable1, representation, ConceptScheme1);
        builder.add(RepresentedVariable2, representation, ConceptScheme2);

        // Create the <ConceptN a Concept> statement for each Concept
        builder.add(Concept1, RDF.TYPE, Concept);
        builder.add(Concept2, RDF.TYPE, Concept);
        builder.add(Concept3, RDF.TYPE, Concept);
        builder.add(Concept4, RDF.TYPE, Concept);
        builder.add(Concept5, RDF.TYPE, Concept);
        builder.add(Concept6, RDF.TYPE, Concept);

        // Create the <ConceptSchemeN hasTopConcept ConceptN> statement for each ConceptScheme1
        // Create the <tr_hasTopConcept a hasTopConcept> statement for each tr_hasTopConcept
        // Create the <tr_hasTopConceptN hasScoreN Values.literal(points)> statement for each tr_hasTopConcept
        // Create the <hasScoreN a hasScore> statement for each hasScore
        Triple tr_hasTopConcept1 = factory.createTriple(ConceptScheme1, hasTopConcept1, Concept1);
        builder.add(tr_hasTopConcept1, RDF.TYPE, hasTopConcept);
        Triple tr_hasScore1 = factory.createTriple(tr_hasTopConcept1, hasScore1, Values.literal("0"));
        builder.add(tr_hasScore1, RDF.TYPE, hasScore);

        Triple tr_hasTopConcept2 = factory.createTriple(ConceptScheme1, hasTopConcept2, Concept2);
        builder.add(tr_hasTopConcept2, RDF.TYPE, hasTopConcept);
        Triple tr_hasScore2 = factory.createTriple(tr_hasTopConcept2, hasScore1, Values.literal("1"));
        builder.add(tr_hasScore2, RDF.TYPE, hasScore);

        Triple tr_hasTopConcept3 = factory.createTriple(ConceptScheme1, hasTopConcept3, Concept3);
        builder.add(tr_hasTopConcept3, RDF.TYPE, hasTopConcept);
        Triple tr_hasScore3 = factory.createTriple(tr_hasTopConcept3, hasScore1, Values.literal("2"));
        builder.add(tr_hasScore3, RDF.TYPE, hasScore);

        Triple tr_hasTopConcept4 = factory.createTriple(ConceptScheme1, hasTopConcept4, Concept4);
        builder.add(tr_hasTopConcept4, RDF.TYPE, hasTopConcept);
        Triple tr_hasScore4 = factory.createTriple(tr_hasTopConcept4, hasScore1, Values.literal("3"));
        builder.add(tr_hasScore4, RDF.TYPE, hasScore);

        Triple tr_hasTopConcept5 = factory.createTriple(ConceptScheme2, hasTopConcept5, Concept5);
        builder.add(tr_hasTopConcept5, RDF.TYPE, hasTopConcept);
        Triple tr_hasScore5 = factory.createTriple(tr_hasTopConcept5, hasScore2, Values.literal("0"));
        builder.add(tr_hasScore5, RDF.TYPE, hasScore);

        Triple tr_hasTopConcept6 = factory.createTriple(ConceptScheme2, hasTopConcept6, Concept6);
        builder.add(tr_hasTopConcept6, RDF.TYPE, hasTopConcept);
        Triple tr_hasScore6 = factory.createTriple(tr_hasTopConcept6, hasScore2, Values.literal("1"));
        builder.add(tr_hasScore6, RDF.TYPE, hasScore);

        // Build the model
        model = builder.build();

        return model;
    }

    public static boolean saveRDFToFile(File file, Model model) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            Rio.write(model, fos, RDFFormat.TURTLESTAR);
            file.setReadable(true, false);
            file.setWritable(true, false);
            file.setExecutable(true, false);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Model addAnswersUCLA(HashMap<String, String> map, Model model){

        IRI QuestionnaireUCLA = factory.createIRI(cmg_vocabulary, "QuestionnaireUCLA");
        IRI Variable1 = factory.createIRI(cmg_vocabulary, "Variable1");
        IRI Variable2 = factory.createIRI(cmg_vocabulary, "Variable2");
        IRI Variable3 = factory.createIRI(cmg_vocabulary, "Variable3");
        IRI Variable4 = factory.createIRI(cmg_vocabulary, "Variable4");
        IRI Variable5 = factory.createIRI(cmg_vocabulary, "Variable5");
        IRI Variable6 = factory.createIRI(cmg_vocabulary, "Variable6");
        IRI Variable7 = factory.createIRI(cmg_vocabulary, "Variable7");
        IRI Variable8 = factory.createIRI(cmg_vocabulary, "Variable8");
        IRI Variable9 = factory.createIRI(cmg_vocabulary, "Variable9");
        IRI Variable10 = factory.createIRI(cmg_vocabulary, "Variable10");
        IRI Variable11 = factory.createIRI(cmg_vocabulary, "Variable11");
        IRI Variable12 = factory.createIRI(cmg_vocabulary, "Variable12");
        IRI Variable13 = factory.createIRI(cmg_vocabulary, "Variable13");
        IRI Variable14 = factory.createIRI(cmg_vocabulary, "Variable14");
        IRI Variable15 = factory.createIRI(cmg_vocabulary, "Variable15");
        IRI Variable16 = factory.createIRI(cmg_vocabulary, "Variable16");
        IRI Variable17 = factory.createIRI(cmg_vocabulary, "Variable17");
        IRI Variable18 = factory.createIRI(cmg_vocabulary, "Variable18");
        IRI Variable19 = factory.createIRI(cmg_vocabulary, "Variable19");
        IRI Variable20 = factory.createIRI(cmg_vocabulary, "Variable20");
        IRI Variable21 = factory.createIRI(cmg_vocabulary, "Variable21");
        IRI Variable22 = factory.createIRI(cmg_vocabulary, "Variable22");
        IRI Variable23 = factory.createIRI(cmg_vocabulary, "Variable23");
        IRI Variable24 = factory.createIRI(cmg_vocabulary, "Variable24");
        IRI Variable25 = factory.createIRI(cmg_vocabulary, "Variable25");
        IRI Variable26 = factory.createIRI(cmg_vocabulary, "Variable26");
        IRI Variable27 = factory.createIRI(cmg_vocabulary, "Variable27");
        IRI Variable28 = factory.createIRI(cmg_vocabulary, "Variable28");
        IRI Variable29 = factory.createIRI(cmg_vocabulary, "Variable29");
        IRI Variable30 = factory.createIRI(cmg_vocabulary, "Variable30");
        IRI Variable31 = factory.createIRI(cmg_vocabulary, "Variable31");
        IRI Variable32 = factory.createIRI(cmg_vocabulary, "Variable32");
        IRI Variable33 = factory.createIRI(cmg_vocabulary, "Variable33");
        IRI Variable34 = factory.createIRI(cmg_vocabulary, "Variable34");

        IRI LogicalDataset = factory.createIRI(disco, "LogicalDataset");
        IRI Dataset = factory.createIRI(qb, "Dataset");
        IRI Observation = factory.createIRI(qb, "Observation");
        IRI aggregation = factory.createIRI(disco, "aggregation");
        IRI dataset = factory.createIRI(qb, "dataset");
        IRI inputVariable = factory.createIRI(qb, "inputVariable");
        IRI hasDate = factory.createIRI(cmg_vocabulary, "hasDate");

        IRI Observation1 = factory.createIRI(cmg_vocabulary, map.get("ans1"));
        IRI Observation2 = factory.createIRI(cmg_vocabulary, map.get("ans2"));
        IRI Observation3 = factory.createIRI(cmg_vocabulary, map.get("ans3"));
        IRI Observation4 = factory.createIRI(cmg_vocabulary, map.get("ans4"));
        IRI Observation5 = factory.createIRI(cmg_vocabulary, map.get("ans5"));
        IRI Observation6 = factory.createIRI(cmg_vocabulary, map.get("ans6"));
        IRI Observation7 = factory.createIRI(cmg_vocabulary, map.get("ans7"));
        IRI Observation8 = factory.createIRI(cmg_vocabulary, map.get("ans8"));
        IRI Observation9 = factory.createIRI(cmg_vocabulary, map.get("ans9"));
        IRI Observation10 = factory.createIRI(cmg_vocabulary, map.get("ans10"));
        IRI Observation11 = factory.createIRI(cmg_vocabulary, map.get("ans11"));
        IRI Observation12 = factory.createIRI(cmg_vocabulary, map.get("ans12"));
        IRI Observation13 = factory.createIRI(cmg_vocabulary, map.get("ans13"));
        IRI Observation14 = factory.createIRI(cmg_vocabulary, map.get("ans14"));
        IRI Observation15 = factory.createIRI(cmg_vocabulary, map.get("ans15"));
        IRI Observation16 = factory.createIRI(cmg_vocabulary, map.get("ans16"));
        IRI Observation17 = factory.createIRI(cmg_vocabulary, map.get("ans17"));
        IRI Observation18 = factory.createIRI(cmg_vocabulary, map.get("ans18"));
        IRI Observation19 = factory.createIRI(cmg_vocabulary, map.get("ans19"));
        IRI Observation20 = factory.createIRI(cmg_vocabulary, map.get("ans20"));
        IRI Observation21 = factory.createIRI(cmg_vocabulary, map.get("ans21"));
        IRI Observation22 = factory.createIRI(cmg_vocabulary, map.get("ans22"));
        IRI Observation23 = factory.createIRI(cmg_vocabulary, map.get("ans23"));
        IRI Observation24 = factory.createIRI(cmg_vocabulary, map.get("ans24"));
        IRI Observation25 = factory.createIRI(cmg_vocabulary, map.get("ans25"));
        IRI Observation26 = factory.createIRI(cmg_vocabulary, map.get("ans26"));
        IRI Observation27 = factory.createIRI(cmg_vocabulary, map.get("ans27"));
        IRI Observation28 = factory.createIRI(cmg_vocabulary, map.get("ans28"));
        IRI Observation29 = factory.createIRI(cmg_vocabulary, map.get("ans29"));
        IRI Observation30 = factory.createIRI(cmg_vocabulary, map.get("ans30"));
        IRI Observation31 = factory.createIRI(cmg_vocabulary, map.get("ans31"));
        IRI Observation32 = factory.createIRI(cmg_vocabulary, map.get("ans32"));
        IRI Observation33 = factory.createIRI(cmg_vocabulary, map.get("ans33"));
        IRI Observation34 = factory.createIRI(cmg_vocabulary, map.get("ans34"));

        IRI Dataset1 = factory.createIRI(cmg_vocabulary, "Dataset1");
        IRI LogicalDataset1 = factory.createIRI(cmg_vocabulary, "LogicalDataset1");
        IRI dataset1 = factory.createIRI(cmg_vocabulary, "dataset1");
        IRI hasDate1 = factory.createIRI(cmg_vocabulary, "hasDate1");
        IRI inputVariable1 = factory.createIRI(cmg_vocabulary, "inputVariable1");
        IRI aggregation1 = factory.createIRI(cmg_vocabulary, "aggregation1");
        IRI instrument1 = factory.createIRI(disco, "instrument1");

        // Create the model builder
        ModelBuilder builder = new ModelBuilder(model);

        builder.add(LogicalDataset1, RDF.TYPE, LogicalDataset);
        builder.add(LogicalDataset, instrument1, QuestionnaireUCLA);

        builder.add(inputVariable1, RDF.TYPE, inputVariable);

        builder.add(hasDate1, RDF.TYPE, hasDate);

        builder.add(Observation1, RDF.TYPE, Observation);
        builder.add(Variable1, inputVariable1, Observation1);

        builder.add(Observation2, RDF.TYPE, Observation);
        builder.add(Variable2, inputVariable1, Observation2);

        builder.add(Observation3, RDF.TYPE, Observation);
        builder.add(Variable3, inputVariable1, Observation3);

        builder.add(Observation4, RDF.TYPE, Observation);
        builder.add(Variable4, inputVariable1, Observation4);

        builder.add(Observation5, RDF.TYPE, Observation);
        builder.add(Variable5, inputVariable1, Observation5);

        builder.add(Observation6, RDF.TYPE, Observation);
        builder.add(Variable6, inputVariable1, Observation6);

        builder.add(Observation7, RDF.TYPE, Observation);
        builder.add(Variable7, inputVariable1, Observation7);

        builder.add(Observation8, RDF.TYPE, Observation);
        builder.add(Variable8, inputVariable1, Observation8);

        builder.add(Observation9, RDF.TYPE, Observation);
        builder.add(Variable9, inputVariable1, Observation9);

        builder.add(Observation10, RDF.TYPE, Observation);
        builder.add(Variable10, inputVariable1, Observation10);

        builder.add(Observation11, RDF.TYPE, Observation);
        builder.add(Variable11, inputVariable1, Observation11);

        builder.add(Observation12, RDF.TYPE, Observation);
        builder.add(Variable12, inputVariable1, Observation12);

        builder.add(Observation13, RDF.TYPE, Observation);
        builder.add(Variable13, inputVariable1, Observation13);

        builder.add(Observation14, RDF.TYPE, Observation);
        builder.add(Variable14, inputVariable1, Observation14);

        builder.add(Observation15, RDF.TYPE, Observation);
        builder.add(Variable15, inputVariable1, Observation15);

        builder.add(Observation16, RDF.TYPE, Observation);
        builder.add(Variable16, inputVariable1, Observation16);

        builder.add(Observation17, RDF.TYPE, Observation);
        builder.add(Variable17, inputVariable1, Observation17);

        builder.add(Observation18, RDF.TYPE, Observation);
        builder.add(Variable18, inputVariable1, Observation18);

        builder.add(Observation19, RDF.TYPE, Observation);
        builder.add(Variable19, inputVariable1, Observation19);

        builder.add(Observation20, RDF.TYPE, Observation);
        builder.add(Variable20, inputVariable1, Observation20);

        builder.add(Observation21, RDF.TYPE, Observation);
        builder.add(Variable21, inputVariable1, Observation21);

        builder.add(Observation22, RDF.TYPE, Observation);
        builder.add(Variable22, inputVariable1, Observation22);

        builder.add(Observation23, RDF.TYPE, Observation);
        builder.add(Variable23, inputVariable1, Observation23);

        builder.add(Observation24, RDF.TYPE, Observation);
        builder.add(Variable24, inputVariable1, Observation24);

        builder.add(Observation25, RDF.TYPE, Observation);
        builder.add(Variable25, inputVariable1, Observation25);

        builder.add(Observation26, RDF.TYPE, Observation);
        builder.add(Variable26, inputVariable1, Observation26);

        builder.add(Observation27, RDF.TYPE, Observation);
        builder.add(Variable27, inputVariable1, Observation27);

        builder.add(Observation28, RDF.TYPE, Observation);
        builder.add(Variable28, inputVariable1, Observation28);

        builder.add(Observation29, RDF.TYPE, Observation);
        builder.add(Variable29, inputVariable1, Observation29);

        builder.add(Observation30, RDF.TYPE, Observation);
        builder.add(Variable30, inputVariable1, Observation30);

        builder.add(Observation31, RDF.TYPE, Observation);
        builder.add(Variable31, inputVariable1, Observation31);

        builder.add(Observation32, RDF.TYPE, Observation);
        builder.add(Variable32, inputVariable1, Observation32);

        builder.add(Observation33, RDF.TYPE, Observation);
        builder.add(Variable33, inputVariable1, Observation33);

        builder.add(Observation34, RDF.TYPE, Observation);
        builder.add(Variable34, inputVariable1, Observation34);

        String timestamp = Instant.now().toString();
        Triple tr_dataset = factory.createTriple(Observation1, dataset1, Dataset1);
        builder.add(Dataset1, RDF.TYPE, Dataset);
        builder.add(tr_dataset, RDF.TYPE, dataset);
        builder.add(tr_dataset, hasDate1, Values.literal(timestamp));

        Triple tr_dataset1 = factory.createTriple(Observation1, dataset1, Dataset1);
        builder.add(tr_dataset1, RDF.TYPE, Dataset1);
        builder.add(tr_dataset1, hasDate1, Values.literal(timestamp));

        Triple tr_dataset2 = factory.createTriple(Observation2, dataset1, Dataset1);
        builder.add(tr_dataset2, RDF.TYPE, Dataset1);
        builder.add(tr_dataset2, hasDate1, Values.literal(timestamp));

        Triple tr_dataset3 = factory.createTriple(Observation3, dataset1, Dataset1);
        builder.add(tr_dataset3, RDF.TYPE, Dataset1);
        builder.add(tr_dataset3, hasDate1, Values.literal(timestamp));

        Triple tr_dataset4 = factory.createTriple(Observation4, dataset1, Dataset1);
        builder.add(tr_dataset4, RDF.TYPE, Dataset1);
        builder.add(tr_dataset4, hasDate1, Values.literal(timestamp));

        Triple tr_dataset5 = factory.createTriple(Observation5, dataset1, Dataset1);
        builder.add(tr_dataset5, RDF.TYPE, Dataset1);
        builder.add(tr_dataset5, hasDate1, Values.literal(timestamp));

        Triple tr_dataset6 = factory.createTriple(Observation6, dataset1, Dataset1);
        builder.add(tr_dataset6, RDF.TYPE, Dataset1);
        builder.add(tr_dataset6, hasDate1, Values.literal(timestamp));

        Triple tr_dataset7 = factory.createTriple(Observation7, dataset1, Dataset1);
        builder.add(tr_dataset7, RDF.TYPE, Dataset1);
        builder.add(tr_dataset7, hasDate1, Values.literal(timestamp));

        Triple tr_dataset8 = factory.createTriple(Observation8, dataset1, Dataset1);
        builder.add(tr_dataset8, RDF.TYPE, Dataset1);
        builder.add(tr_dataset8, hasDate1, Values.literal(timestamp));

        Triple tr_dataset9 = factory.createTriple(Observation9, dataset1, Dataset1);
        builder.add(tr_dataset9, RDF.TYPE, Dataset1);
        builder.add(tr_dataset9, hasDate1, Values.literal(timestamp));

        Triple tr_dataset10 = factory.createTriple(Observation10, dataset1, Dataset1);
        builder.add(tr_dataset10, RDF.TYPE, Dataset1);
        builder.add(tr_dataset10, hasDate1, Values.literal(timestamp));

        Triple tr_dataset11 = factory.createTriple(Observation11, dataset1, Dataset1);
        builder.add(tr_dataset11, RDF.TYPE, Dataset1);
        builder.add(tr_dataset11, hasDate1, Values.literal(timestamp));

        Triple tr_dataset12 = factory.createTriple(Observation12, dataset1, Dataset1);
        builder.add(tr_dataset12, RDF.TYPE, Dataset1);
        builder.add(tr_dataset12, hasDate1, Values.literal(timestamp));

        Triple tr_dataset13 = factory.createTriple(Observation13, dataset1, Dataset1);
        builder.add(tr_dataset13, RDF.TYPE, Dataset1);
        builder.add(tr_dataset13, hasDate1, Values.literal(timestamp));

        Triple tr_dataset14 = factory.createTriple(Observation14, dataset1, Dataset1);
        builder.add(tr_dataset14, RDF.TYPE, Dataset1);
        builder.add(tr_dataset14, hasDate1, Values.literal(timestamp));

        Triple tr_dataset15 = factory.createTriple(Observation15, dataset1, Dataset1);
        builder.add(tr_dataset15, RDF.TYPE, Dataset1);
        builder.add(tr_dataset15, hasDate1, Values.literal(timestamp));

        Triple tr_dataset16 = factory.createTriple(Observation16, dataset1, Dataset1);
        builder.add(tr_dataset16, RDF.TYPE, Dataset1);
        builder.add(tr_dataset16, hasDate1, Values.literal(timestamp));

        Triple tr_dataset17 = factory.createTriple(Observation17, dataset1, Dataset1);
        builder.add(tr_dataset17, RDF.TYPE, Dataset1);
        builder.add(tr_dataset17, hasDate1, Values.literal(timestamp));

        Triple tr_dataset18 = factory.createTriple(Observation18, dataset1, Dataset1);
        builder.add(tr_dataset18, RDF.TYPE, Dataset1);
        builder.add(tr_dataset18, hasDate1, Values.literal(timestamp));

        Triple tr_dataset19 = factory.createTriple(Observation19, dataset1, Dataset1);
        builder.add(tr_dataset19, RDF.TYPE, Dataset1);
        builder.add(tr_dataset19, hasDate1, Values.literal(timestamp));

        Triple tr_dataset20 = factory.createTriple(Observation20, dataset1, Dataset1);
        builder.add(tr_dataset20, RDF.TYPE, Dataset1);
        builder.add(tr_dataset20, hasDate1, Values.literal(timestamp));

        Triple tr_dataset21 = factory.createTriple(Observation21, dataset1, Dataset1);
        builder.add(tr_dataset21, RDF.TYPE, Dataset1);
        builder.add(tr_dataset21, hasDate1, Values.literal(timestamp));

        Triple tr_dataset22 = factory.createTriple(Observation22, dataset1, Dataset1);
        builder.add(tr_dataset22, RDF.TYPE, Dataset1);
        builder.add(tr_dataset22, hasDate1, Values.literal(timestamp));

        Triple tr_dataset23 = factory.createTriple(Observation23, dataset1, Dataset1);
        builder.add(tr_dataset23, RDF.TYPE, Dataset1);
        builder.add(tr_dataset23, hasDate1, Values.literal(timestamp));

        Triple tr_dataset24 = factory.createTriple(Observation24, dataset1, Dataset1);
        builder.add(tr_dataset24, RDF.TYPE, Dataset1);
        builder.add(tr_dataset24, hasDate1, Values.literal(timestamp));

        Triple tr_dataset25 = factory.createTriple(Observation25, dataset1, Dataset1);
        builder.add(tr_dataset25, RDF.TYPE, Dataset1);
        builder.add(tr_dataset25, hasDate1, Values.literal(timestamp));

        Triple tr_dataset26 = factory.createTriple(Observation26, dataset1, Dataset1);
        builder.add(tr_dataset26, RDF.TYPE, Dataset1);
        builder.add(tr_dataset26, hasDate1, Values.literal(timestamp));

        Triple tr_dataset27 = factory.createTriple(Observation27, dataset1, Dataset1);
        builder.add(tr_dataset27, RDF.TYPE, Dataset1);
        builder.add(tr_dataset27, hasDate1, Values.literal(timestamp));

        Triple tr_dataset28 = factory.createTriple(Observation28, dataset1, Dataset1);
        builder.add(tr_dataset28, RDF.TYPE, Dataset1);
        builder.add(tr_dataset28, hasDate1, Values.literal(timestamp));

        Triple tr_dataset29 = factory.createTriple(Observation29, dataset1, Dataset1);
        builder.add(tr_dataset29, RDF.TYPE, Dataset1);
        builder.add(tr_dataset29, hasDate1, Values.literal(timestamp));

        Triple tr_dataset30 = factory.createTriple(Observation30, dataset1, Dataset1);
        builder.add(tr_dataset30, RDF.TYPE, Dataset1);
        builder.add(tr_dataset30, hasDate1, Values.literal(timestamp));

        Triple tr_dataset31 = factory.createTriple(Observation31, dataset1, Dataset1);
        builder.add(tr_dataset31, RDF.TYPE, Dataset1);
        builder.add(tr_dataset31, hasDate1, Values.literal(timestamp));

        Triple tr_dataset32 = factory.createTriple(Observation32, dataset1, Dataset1);
        builder.add(tr_dataset32, RDF.TYPE, Dataset1);
        builder.add(tr_dataset32, hasDate1, Values.literal(timestamp));

        Triple tr_dataset33 = factory.createTriple(Observation33, dataset1, Dataset1);
        builder.add(tr_dataset33, RDF.TYPE, Dataset1);
        builder.add(tr_dataset33, hasDate1, Values.literal(timestamp));

        Triple tr_dataset34 = factory.createTriple(Observation34, dataset1, Dataset1);
        builder.add(tr_dataset34, RDF.TYPE, Dataset1);
        builder.add(tr_dataset34, hasDate1, Values.literal(timestamp));

        builder.add(factory.createTriple(LogicalDataset1, aggregation1, Dataset1), RDF.TYPE, aggregation);
        builder.add(LogicalDataset1, RDF.TYPE, LogicalDataset);

        model = builder.build();

        return model;
    }

    public static String printModel(Model model){
        StringBuilder result = new StringBuilder();
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

    public static Model readRDFFromFile(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            return Rio.parse(fis, "", RDFFormat.TURTLESTAR);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
