package javaQues;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileReader {

	public CSVFileReader() {

	}

	private ArrayList<Person> people = new ArrayList<Person>();

	public ArrayList<Person> read(String inputFileName) {
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(inputFileName));

			String CSVLine;

			while ((CSVLine = br.readLine()) != null) {
				String[] CSVData = CSVLine.split(",");

				if (CSVData.length != 5) {
					System.out.println("カラム数が不正な行があります。");
					continue;
				}

				Person human = new Person(CSVData[0], CSVData[1], CSVData[2], CSVData[3], CSVData[4]);

				people.add(human);

			}
		} catch (IOException e) {
			System.out.println("ファイルの読み込みに失敗しました。");
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("ファイルの読み込みに失敗しました。");
					e.printStackTrace();
				}
			}
		}
		return people;
	}

}
