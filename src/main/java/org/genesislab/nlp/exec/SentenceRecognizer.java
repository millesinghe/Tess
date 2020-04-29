package org.genesislab.nlp.exec;

import java.util.List;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class SentenceRecognizer {

	public static void main(String[] args) {

		String text = "Hey!, I'm Milinda Bandara. I graduate from University of Westminster. Currently working as a Software Engineer";

		StanfordCoreNLP stanfordCoreNLP = NLPEngine.getNLPEngine();

		CoreDocument coreDoc = new CoreDocument(text);
		stanfordCoreNLP.annotate(coreDoc);
		
		List<CoreSentence> sentenceList = coreDoc.sentences();
		
		for(CoreSentence sentence : sentenceList){
			System.out.println(sentence.toString());
		}
		
	}

}
