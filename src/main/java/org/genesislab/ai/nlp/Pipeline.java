package org.genesislab.ai.nlp;

import java.util.Properties;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class Pipeline {

	//tokenize - tokenizing the words
	//ssplit - spliting the sentences
	//pos - part of speech connection of the words
	//lemma - identify the root word of the word
	// sentiment - Identify the Negative Nuetral Positivenes of the statement
	private static String PROPERTIES_NAME = "tokenize, ssplit, pos, lemma, parse, sentiment";
	
	//ner - name entity recognizer - takes performance
	//private static String PROPERTIES_NAME = "ner";
	
	private static StanfordCoreNLP nlpCore;
	
	private static Properties prop;
	

	private Pipeline(){}
	
	static {
		prop = new Properties();
		prop.setProperty("annotators", PROPERTIES_NAME);
	}
	
	public static StanfordCoreNLP getPipeline(){
		
		if(nlpCore == null){
			nlpCore = new StanfordCoreNLP(prop);
		}
		
		return nlpCore; 
	}
}
