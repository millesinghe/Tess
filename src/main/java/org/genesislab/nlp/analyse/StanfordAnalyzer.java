package org.genesislab.nlp.analyse;

import java.util.List;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;

public class StanfordAnalyzer {

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
