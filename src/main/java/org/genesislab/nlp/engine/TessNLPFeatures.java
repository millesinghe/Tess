package org.genesislab.nlp.engine;

public class TessNLPFeatures {

	//"tokenize, ssplit, pos, lemma, parse, sentiment, ner"
	private String PROPERTIES_NAME = "";
	
	public TessNLPFeatures tokenize(){
		if (!PROPERTIES_NAME.contains("tokenize")) 
			PROPERTIES_NAME += " tokenize,";
		
		return this;
	}
	
	public TessNLPFeatures sentenceSplit(){
		if (!PROPERTIES_NAME.contains("ssplit")) 
			PROPERTIES_NAME += " ssplit,";
		return this;
	}
	
	public TessNLPFeatures partOfSentence(){
		if (!PROPERTIES_NAME.contains("tokenize")) {
			PROPERTIES_NAME += " tokenize,";
		}
		if (!PROPERTIES_NAME.contains("ssplit")) {
			PROPERTIES_NAME += " ssplit,";
		}
		PROPERTIES_NAME += " pos,";
		return this;
	}
	
	public TessNLPFeatures lemmatizatize(){
		if (!PROPERTIES_NAME.contains("tokenize")) {
			PROPERTIES_NAME += " tokenize,";
		}
		if (!PROPERTIES_NAME.contains("ssplit")) {
			PROPERTIES_NAME += " ssplit,";
		}
		if (!PROPERTIES_NAME.contains("pos")) {
			PROPERTIES_NAME += " pos,";
		}
		PROPERTIES_NAME += " lemma,";
		return this;
	}
	
	public TessNLPFeatures sentiment(){

		if (!PROPERTIES_NAME.contains("sentiment")) 
		PROPERTIES_NAME += " parse, sentiment,";
		return this;
	}
	
	public TessNLPFeatures nameEntityRelation(){

		if (!PROPERTIES_NAME.contains("ner")) 
			PROPERTIES_NAME += " ner,";
		return this;
	}
	
	public String build(){
		PROPERTIES_NAME = PROPERTIES_NAME.substring(0,PROPERTIES_NAME.length()-1);
		return PROPERTIES_NAME;
	}
	
	

	
}
