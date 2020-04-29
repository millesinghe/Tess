package org.genesislab.nlp.analyse;

import java.util.List;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;

public class SentenceSplitter {

	private void analyseSentenceIdenty(CoreDocument doc) {
		List<CoreSentence> sentenceList = doc.sentences();

		for (CoreSentence sentence : sentenceList) {
			System.out.println(sentence.toString());
		}
	}
}
