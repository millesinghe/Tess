package org.genesislab.nlp.analyse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.genesislab.nlp.dao.TessChunkSentence;
import org.genesislab.nlp.dao.TessSentence;
import org.genesislab.nlp.dao.TessWord;

public class Chunker {

	private List<TessChunkSentence> chunkSentences;

	private static String[] chunkKeyWordsCategories = { "PRP", "NNP", "NN", "JJ", "VBG", "NNS" };

	private TessSentence sentence;

	private HashMap<String, List> chunkKeyWords;

	public Chunker(TessSentence senta) {
		chunkSentences = new ArrayList<TessChunkSentence>();
		this.sentence = senta;
	}

	public void process() {
		chunkKeyWords = new HashMap<String, List>();
		System.out.println("----------------------------------------------");
		this.processChunker("WP");
		this.processChunker("IN");
		chunkKeyWords.get("innovative");
	}

	private void processChunker(String pos) {
		String senta = sentence.getSentence();

		if (sentence.getListPos().contains(pos)) {

			String prime = "";
			String second = "";

			boolean isNext = false;
			String flagType = "";

			List<TessWord> listWords = new ArrayList<TessWord>();
			List<String> listPos = new ArrayList<String>();

			for (TessWord word : sentence.getWords()) {
				if (word.getPosValue().equals(pos)) {
					isNext = true;
					flagType = word.getWord();
					
					TessSentence tessPrimeSenta = new TessSentence(prime, listWords);
					this.processKeyWordCategory(tessPrimeSenta);
					
					listWords = new ArrayList<TessWord>();
					continue;
				}
				if (!isNext) {
					prime += word.getWord() + " ";
					listWords.add(word);
				} else {
					second += word.getWord() + " ";
					listWords.add(word);
				}

			}

			TessSentence tessSecSenta = new TessSentence(second,listWords);
			this.processKeyWordCategory(tessSecSenta);
			

			chunkSentences.add(new TessChunkSentence(flagType, prime, second));

		}
		System.out.println();
	}

	private void processKeyWordCategory(TessSentence extractSentence) {
		for (TessWord word : extractSentence.getWords()) {
			if (Arrays.asList(chunkKeyWordsCategories).contains(word.getPosValue())) {
				if (chunkKeyWords.get(word.getWord()) == null) {
					ArrayList<TessSentence> sentaListToKeyWord = new ArrayList<TessSentence>();
					sentaListToKeyWord.add(extractSentence);
					chunkKeyWords.put(word.getWord(), sentaListToKeyWord);
				} else {
					List sentaListToKeyWord = chunkKeyWords.get(word.getWord());
					sentaListToKeyWord.add(extractSentence);
				}
			}
		}
	}

}
