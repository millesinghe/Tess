package org.genesislab.nlp.exec;

import java.util.List;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class ExecuteStart {

	//http://nlp.stanford.edu:8080/corenlp/process
	
	public static void main(String[] args) {
		//String text = "Hey, I am Milinda and Interesting and Learning on innovative and trending tecnologies. I have a brother, His name is Thilina Namal. We lives in Kurunegala, Sri Lanka.  I graduate from University of Westminster. Currently working as a Software Engineer. I don't like to be a typical Software Engineer. But I like to be a innovative tech engineer. Specially I not like to loose.";
	
		String text = "I am Milinda and Interesting and Learning on innovative and trending technologies.";

		System.out.println("--------------------- App Starts");
		StanfordCoreNLP stanfordCoreNLP = NLPEngine.getNLPEngine();

		System.out.println("--------------------- App Initialzied");

		CoreDocument doc = new CoreDocument(text);

		System.out.println("--------------------- Doc Injected");

		stanfordCoreNLP.annotate(doc);
		System.out.println("--------------------- App annotated");

		ExecuteStart ex = new ExecuteStart();

		System.out.println("\n\n\n--------------------- Init POS");
		ex.analysePos(doc);
		System.out.println("--------------------- End POS");

		System.out.println("\n\n\n--------------------- Init Lemmatizer");
		ex.analyseLemet(doc);
		System.out.println("--------------------- End Lemmatizer");

		System.out.println("\n\n\n--------------------- Init Sentence Identify");
		ex.analyseSentenceIdenty(doc);
		System.out.println("--------------------- End Sentence Identify");

		System.out.println("\n\n\n--------------------- Init Sentimental");
		ex.analyseSentimental(doc);
		System.out.println("--------------------- End Sentimental");

		System.out.println("\n\n\n--------------------- Init Token");
		ex.analyseToken(doc);
		System.out.println("--------------------- End Token");

		System.out.println("\n\n\n--------------------- Init NER");
		ex.analyseNER(doc);
		System.out.println("--------------------- End NER");

	}

	private void analyseNER(CoreDocument doc) {
		List<CoreLabel> wordList = doc.tokens();

		for (CoreLabel word : wordList) {

			String ner = word.get(CoreAnnotations.NamedEntityTagAnnotation.class);
			System.out.println(word.originalText() + " - " + ner);
		}
	}

	private void analyseToken(CoreDocument doc) {
		List<CoreLabel> coreLabelList = doc.tokens();

		for (CoreLabel coreLabel : coreLabelList) {
			System.out.println(coreLabel.originalText());
		}
	}

	private void analyseSentimental(CoreDocument doc) {
		List<CoreSentence> sentenceList = doc.sentences();

		for (CoreSentence sentence : sentenceList) {
			String sentiment = sentence.sentiment();
			System.out.println(sentiment + " \t" + sentence.toString());
		}
	}

	private void analyseSentenceIdenty(CoreDocument doc) {
		List<CoreSentence> sentenceList = doc.sentences();

		for (CoreSentence sentence : sentenceList) {
			System.out.println(sentence.toString());
		}
	}

	private void analyseLemet(CoreDocument doc) {
		List<CoreLabel> wordList = doc.tokens();

		for (CoreLabel word : wordList) {
			String lemma = word.lemma();
			System.out.println(lemma + " - " + word.originalText());
		}
	}

	private void analysePos(CoreDocument doc) {

		List<CoreLabel> wordList = doc.tokens();

		for (CoreLabel word : wordList) {

			String pos = word.get(CoreAnnotations.PartOfSpeechAnnotation.class);
			System.out.println(pos + " - " + word.originalText());
		}
	}

}
