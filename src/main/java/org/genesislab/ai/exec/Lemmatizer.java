package org.genesislab.ai.exec;

import java.util.List;

import org.genesislab.ai.nlp.Pipeline;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class Lemmatizer {

	public static void main(String[] args) {
		
		String text = "Hey, I am Milinda and Interesting and Learning on innovative and trending tecnologies.";

		StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

		CoreDocument doc = new CoreDocument(text);

		stanfordCoreNLP.annotate(doc);

		List<CoreLabel> wordList = doc.tokens();

		for (CoreLabel word : wordList) {

			String lemma = word.lemma();
			System.out.println(lemma + " - " + word.originalText());
		}
	}

}
