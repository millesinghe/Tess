package org.genesislab.nlp.engine;

import java.util.Properties;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class TessEngine {

	// tokenize - tokenizing the words
	// ssplit - spliting the sentences
	// pos - part of speech connection of the words
	// lemma - identify the root word of the word
	// sentiment - Identify the Negative Nuetral Positivenes of the statement

	// ner - name entity recognizer - takes performance
	//All values assign to the featureProp
	
	private static TessEngine tess;
	
	private static StanfordCoreNLP nlpCore;

	private static Properties prop;

	private TessEngine(){}

	public static TessEngine getTess(String featureProp) {

		if (tess == null) {
			tess =  new TessEngine();
			prop = new Properties();
			prop.setProperty("annotators", featureProp);
			nlpCore = new StanfordCoreNLP(prop);
		}

		return tess;
	}
	
	public StanfordCoreNLP getNLPEngine(){
		return nlpCore;
	}
	
	public static StanfordCoreNLP setProcessDocument(){
		return nlpCore;
	}
}
