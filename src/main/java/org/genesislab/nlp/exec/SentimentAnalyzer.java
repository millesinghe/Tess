package org.genesislab.nlp.exec;

import java.util.List;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class SentimentAnalyzer {

	public static void main(String[] args) {

		String text = "Hey!, I'm Milinda Bandara. I don't like to be a typical Software Engineer. But I like to be a innovative tech engineer. Specially I not like to loose";

		StanfordCoreNLP stanfordCoreNLP = NLPEngine.getNLPEngine();

		CoreDocument coreDoc = new CoreDocument(text);
		stanfordCoreNLP.annotate(coreDoc);

		List<CoreSentence> sentenceList = coreDoc.sentences();

		for (CoreSentence sentence : sentenceList) {
			String sentiment = sentence.sentiment();
			System.out.println(sentiment + " \t" + sentence.toString());
		}

	}
}
