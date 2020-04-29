package org.genesislab.nlp.engine;

import edu.stanford.nlp.pipeline.CoreDocument;

public class NLPDocumentBuilder {

	private CoreDocument nlpDocument;
	
	public NLPDocumentBuilder(TessEngine tess, String content){
		 nlpDocument = new CoreDocument(content);
		tess.getNLPEngine().annotate(nlpDocument);
	}

	public CoreDocument getNlpDocument() {
		return nlpDocument;
	}
}
