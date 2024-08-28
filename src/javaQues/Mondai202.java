package javaQues;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

public class Mondai202 {

	public static void main(String[] args) {
		BufferedReader br1 = null;
		BufferedReader br2 = null;

		try {
			br1 = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("読み込むファイル名を指定して下さいーー＞");

			String readFileName = br1.readLine();

			File file = new File(readFileName);

			while (true) {
				if (file.exists()) {
					ArrayList<Person> people = new ArrayList<>();

					CSVFileReader csfr = new CSVFileReader();

					people = csfr.read(readFileName);

					br2 = new BufferedReader(new InputStreamReader(System.in));

					System.out.print("書き込むファイル名を指定して下さいーー＞");

					String writeFileName = br2.readLine();

					CSVFileWriter csvfw = new CSVFileWriter(writeFileName);

					csvfw.write(people);

				} else {
					System.out.println("存在しないファイルが読込ファイルとして指定されました。");
				}
			}

		} catch (IOException e) {
			System.out.println("ファイルの読み込みに失敗しました。");
		} finally {
			try {
				if (br1 != null) {
					br1.close();
				}
				if (br2 != null) {
					br2.close();
				}
			} catch (IOException e) {
				System.out.println("ファイルのクローズに失敗しました。");
			}
		}

	}

}
