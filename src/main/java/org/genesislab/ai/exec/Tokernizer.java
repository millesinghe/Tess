package org.genesislab.ai.exec;

import java.util.List;

import org.genesislab.ai.nlp.Pipeline;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class Tokernizer {

	public static void main(String[] args) {

		String text = "Hey!, Im Milinda Bandara";

		StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();

		CoreDocument coreDoc = new CoreDocument(text);
		stanfordCoreNLP.annotate(coreDoc);

		// uses CoreDocument Token Feature
		List<CoreLabel> coreLabelList = coreDoc.tokens();

		for (CoreLabel coreLabel : coreLabelList) {
			System.out.println(coreLabel.originalText());
		}
	}

}
