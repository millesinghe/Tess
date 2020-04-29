package org.genesislab.nlp.dao;

public class TessChunkSentence {

	private String connector;
	
	private String primarySenta;
	
	private String secondarySenta;

	
	
	public TessChunkSentence(String connector, String primarySenta, String secondarySenta) {
		this.connector = connector;
		this.primarySenta = primarySenta;
		this.secondarySenta = secondarySenta;
	}

	public String getConnector() {
		return connector;
	}

	public void setConnector(String connector) {
		this.connector = connector;
	}

	public String getPrimarySenta() {
		return primarySenta;
	}

	public void setPrimarySenta(String primarySenta) {
		this.primarySenta = primarySenta;
	}

	public String getSecondarySenta() {
		return secondarySenta;
	}

	public void setSecondarySenta(String secondarySenta) {
		this.secondarySenta = secondarySenta;
	}
	
	
	
}
