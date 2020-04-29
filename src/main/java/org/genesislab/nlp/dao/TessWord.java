package org.genesislab.nlp.dao;

public class TessWord {

	private int wordNo;

	private String word;

	private String posValue;

	private String lemma;

	private String ner;

	public TessWord(int j, String nlpWord, String pos, String lemma, String ner) {
		this.wordNo = j;
		this.word = nlpWord;
		this.posValue = pos;
		this.lemma = lemma;
		this.ner = ner;
	}

	public int getWordNo() {
		return wordNo;
	}

	public void setWordNo(int wordNo) {
		this.wordNo = wordNo;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getPosValue() {
		return posValue;
	}

	public void setPosValue(String posValue) {
		this.posValue = posValue;
	}

	public String getLemma() {
		return lemma;
	}

	public void setLemma(String lemma) {
		this.lemma = lemma;
	}

	public String getNer() {
		return ner;
	}

	public void setNer(String ner) {
		this.ner = ner;
	}

	public void stats() {
		System.out.println( this.wordNo + " - " + this.word + " - " + this.posValue + " - " + this.lemma + " - " + this.ner );
	}
	
}

