package javaQues;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVWriter {
	private ArrayList<Person> people = new ArrayList<>();
	private String outputFileName;

	public CSVWriter(String outputFileName) {
		this.outputFileName = outputFileName;
	}

	public void writer() {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(outputFileName));

			for (Person human : people) {
				bw.write(human.getName());
				bw.write(",");
				bw.write(human.getAge());
				bw.write(",");
				bw.write(human.getGender());
				bw.write(",");
				bw.write(human.getAddress());
				bw.write(",");
				bw.write(human.getJob());
				bw.write(",");
				bw.newLine();
			}
			bw.close();

			System.out.println("正常に保存されました。");
		} catch (IOException e) {
			System.out.println("ファイルの書き込みに失敗しました。");
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
			} catch (IOException e) {
				System.out.println("ファイルをクローズ出来ませんでした。");
			}
		}
	}

	public void dataCollect(String inputLine) {

		String[] input = inputLine.split(",");

		if (input.length == 5) {
			Person human = new Person(input[0], input[1], input[2], input[3], input[4]);
			people.add(human);
		} else {
			System.out.println("カラム数が不正です。");
		}

	}

}
