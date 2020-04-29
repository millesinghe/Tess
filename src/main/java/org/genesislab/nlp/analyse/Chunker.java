package org.genesislab.nlp.analyse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.genesislab.nlp.dao.TessChunkSentence;
import org.genesislab.nlp.dao.TessSentence;
import org.genesislab.nlp.dao.TessWord;

public class Chunker {

	private List<TessChunkSentence> chunkSentences;


	private TessSentence sentence;

	public Chunker(TessSentence senta) {
		chunkSentences = new ArrayList<TessChunkSentence>();
		this.sentence = senta;
	}

	public void process() {
		this.processChunker("WP");
		this.processChunker("IN");

	}

	private void processChunker(String pos) {
		String senta = sentence.getSentence();

		if (sentence.getListPos().contains(pos)) {

			String prime = "";
			String second = "";

			boolean isNext = false;
			String flagType = "";

			for (TessWord word : sentence.getWords()) {
				if (word.getPosValue().equals(pos)) {
					isNext = true;
					flagType = word.getWord();
					continue;
				}
				if (!isNext) {
					prime += word.getWord() + " ";
				} else {
					second += word.getWord() + " ";
				}
			}

			chunkSentences.add(new TessChunkSentence(flagType, prime, second));

		}
		System.out.println();
	}

}
