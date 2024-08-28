package javaQues;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Mondai201 {

	public static void main(String[] args) {

		BufferedReader br = null;

		try {
			while (true) {
				br = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("ファイルの読み込みを行います。");
				System.out.print("ファイル名を指定して下さいーー＞");

				String inputFileName = br.readLine();

				File file = new File(inputFileName);

				if (file.exists()) {

					ArrayList<Person> people = new ArrayList<>();

					CSVFileReader csfr = new CSVFileReader();

					people = csfr.read(inputFileName);

					for (Person human : people) {
						System.out.println("*********************************");
						System.out.println("氏名：" + human.getName());
						System.out.println("年齢：" + human.getAge());
						System.out.println("性別：" + human.getGender());
						System.out.println("住所：" + human.getAddress());
						System.out.println("職業：" + human.getJob());
						System.out.println("*********************************");
					}
					break;
				} else {
					System.out.println("存在しないファイルが指定されました。");
				}

			}

		} catch (IOException e) {
			System.out.println("ファイルの読み込みに失敗しました。");
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.out.println("ファイルのクローズに失敗しました。");
			}
		}

	}

}
