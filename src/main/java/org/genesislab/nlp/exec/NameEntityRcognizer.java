package org.genesislab.nlp.exec;

import java.util.List;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class NameEntityRcognizer {

	public static void main(String[] args) {

		String text = "Hey, Im Milinda Bandara. I have a brother, His name is Thilina Namal. We lives in Kurunegala, Sri Lanka";

		StanfordCoreNLP core = NLPEngine.getNLPEngine();

		CoreDocument doc = new CoreDocument(text);
		core.annotate(doc);

		List<CoreLabel> wordList = doc.tokens();

		for (CoreLabel word : wordList) {

			String ner = word.get(CoreAnnotations.NamedEntityTagAnnotation.class);
			System.out.println(word.originalText() + " - " + ner);
		}
	}

}
