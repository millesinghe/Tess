package org.genesislab.nlp.dao;

import java.util.List;

public class TessSentence {

	private String sentence;
	
	private String sentiment;

	private int id;

	private List<TessWord> words;

	private List<String> listPos;
	
	public TessSentence(int id, String sentence, String sentiment, List<TessWord> listWords, List<String> listPos) {
		this.id= id;
		this.setSentence(sentence);
		this.setSentiment(sentiment);
		this.setWords(listWords);
		this.setListPos(listPos);
	}

	public String getSentence() {
		return sentence;
	}

	public void setSentence(String sentence) {
		this.sentence = sentence;
	}

	public String getSentiment() {
		return sentiment;
	}

	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}

	public int getId() {
		return id;
	}

	public List<TessWord> getWords() {
		return words;
	}

	public void setWords(List<TessWord> words) {
		this.words = words;
	}

	public List<String> getListPos() {
		return listPos;
	}

	public void setListPos(List<String> listPos) {
		this.listPos = listPos;
	}

}
