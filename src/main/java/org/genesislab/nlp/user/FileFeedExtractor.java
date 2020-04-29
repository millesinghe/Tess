package org.genesislab.nlp.user;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.genesislab.nlp.extract.InfoExtractor;

public class FileFeedExtractor {

	public static void main(String[] args) {
		
		FileFeedExtractor ffd = new FileFeedExtractor();
		
		//String name = ffd.getFileName();
		String name = "Docs/Sample.txt";
		String content = ffd.loadFile(name);
		
		InfoExtractor infoExtract = new InfoExtractor();
		infoExtract.preProcess(content);
		infoExtract.process();

	}

	private String getFileName() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the File needs to read : ");
		String name = sc.nextLine();
		name = "Docs/Sample.txt";
		return name;
	}

	private String loadFile(String fileName) {
		 
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName)) {

            String result = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            System.out.println(result);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

		System.out.println("");
		return null;
	}

}
