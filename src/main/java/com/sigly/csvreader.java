package com.sigly;

import java.io.FileReader;
import com.opencsv.CSVReader;

import com.google.gson.Gson;

import org.json.CDL;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class csvreader {
	private csvreader() {

	}

	public static void main(String[] args) {
		readCsvUsingOpenCsv("C:\\Users\\Shubham.Debnath\\Desktop\\input.csv");
	}

	private static void readCsvUsingOpenCsv(String filePath) {
		try {
			CSVReader reader = new CSVReader(new FileReader(filePath));

			String[] nextLine;

			while ((nextLine = reader.readNext()) != null) {
				User user = new User(nextLine[0], nextLine[1], nextLine[2], nextLine[3]);

				for (String value : nextLine) {
					System.out.print(value + "\t");
				}
				 System.out.println();
				System.out.println(new Gson().toJson(user));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
