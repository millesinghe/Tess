package org.genesislab.nlp.exec;

import java.util.Properties;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class NLPEngine {

	// tokenize - tokenizing the words
	// ssplit - spliting the sentences
	// pos - part of speech connection of the words
	// lemma - identify the root word of the word
	// sentiment - Identify the Negative Nuetral Positivenes of the statement

	// ner - name entity recognizer - takes performance
	private static String PROPERTIES_NAME = "tokenize, ssplit, pos, lemma, parse, sentiment";


	private static StanfordCoreNLP nlpCore;

	private static Properties prop;

	private NLPEngine(){}

	static {
		prop = new Properties();
		prop.setProperty("annotators", PROPERTIES_NAME);
	}

	public static StanfordCoreNLP getNLPEngine() {

		if (nlpCore == null) {
			nlpCore = new StanfordCoreNLP(prop);
		}

		return nlpCore;
	}
}
