package javaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mondai203 {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedReader inputLine = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("書き込むファイル名を指定して下さい ---------- ");

			String outputFileName = br.readLine();

			inputLine = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("データを入力してください。「E」を入力すると保存を開始するため、書き込みを終了します。");

			System.out.println("例のように入力してください。例：名前,年齢,性別,出身都道府県,職業");

			CSVWriter cw = new CSVWriter(outputFileName);

			while (true) {
				String writeLine = inputLine.readLine();

				if (writeLine.equals("E")) {
					System.out.println("「E」が入力されました。書き込みを終了します。");
					cw.writer();
					break;
				}

				cw.dataCollect(writeLine);

			}

		} catch (IOException e) {
			System.out.println("ファイルの読み込みに失敗しました。");
		}

	}

}
