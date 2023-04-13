package com.sigly;

import org.json.CDL;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class App {
	private App() {

	}

	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("Read Data Line by Line With Header \n");
		try {
			File initialFile = new File("input.csv");
			//	File initialFile = new File("C:\\Users\\Shubham.Debnath\\Desktop\\input.csv");
			InputStream targetStream = new FileInputStream(initialFile);
			String csvAsString = new BufferedReader(new InputStreamReader(targetStream)).lines()
					.collect(Collectors.joining("\n"));
			String json = CDL.toJSONArray(csvAsString).toString();
			System.out.println(json);
			targetStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}