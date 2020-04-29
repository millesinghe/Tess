package org.genesislab.nlp.extract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.genesislab.nlp.analyse.Chunker;
import org.genesislab.nlp.dao.TessSentence;
import org.genesislab.nlp.dao.TessWord;
import org.genesislab.nlp.engine.NLPDocumentBuilder;
import org.genesislab.nlp.engine.TessEngine;
import org.genesislab.nlp.engine.TessNLPFeatures;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;

public class InfoExtractor {

	List<TessSentence> sentenceList;

	TessEngine tess;

	public InfoExtractor() {
		sentenceList = new ArrayList<TessSentence>();

		String featureProp = new TessNLPFeatures().tokenize().lemmatizatize().partOfSentence().sentenceSplit()
				.sentiment()
				// .nameEntityRelation()
				.build();

		tess = TessEngine.getTess(featureProp);

	}

	public void preProcess(String content) {

		// Build the Document
		NLPDocumentBuilder nlpDocumentBuilder = new NLPDocumentBuilder(tess, content);
		CoreDocument tessDocument = nlpDocumentBuilder.getNlpDocument();

		// word splitter and insert to list
		List<CoreSentence> listSentences = tessDocument.sentences();

		for (int i = 0; i < listSentences.size(); i++) {

			CoreSentence senta = listSentences.get(i);
			String sentiment = listSentences.get(i).sentiment();

			// tokenize the words
			List<TessWord> listWords = new ArrayList<TessWord>();
			List<String> listPos = new ArrayList<String>();

			List<CoreLabel> words = senta.tokens();

			for (int j = 0; j < words.size(); j++) {

				CoreLabel coreLable = words.get(j);

				String nlpWord = coreLable.originalText();
				String pos = coreLable.get(CoreAnnotations.PartOfSpeechAnnotation.class);
				listPos.add(pos);

			

				String lemma = coreLable.lemma();
				String ner = coreLable.get(CoreAnnotations.NamedEntityTagAnnotation.class);

				TessWord word = new TessWord(j, nlpWord.toLowerCase(), pos, lemma, ner);

				listWords.add(word);
			}

			TessSentence tessSenta = new TessSentence(senta.toString().toLowerCase(), sentiment, listWords, listPos);
			sentenceList.add(tessSenta);

		}

		System.out.println(listSentences);
	}

	public void process() {

		TessSentence aaa = sentenceList.get(0);
		List<TessWord> words = aaa.getWords();

		words.forEach(word -> word.stats());
		System.out.println("-------------------");

		Chunker c = new Chunker(aaa);
		c.process();

		for (TessWord word : words) {
			// word.stats();
			if (word.getPosValue().contains("NN")) {
				word.stats();
			}
		}

		System.out.println();

	}

}
