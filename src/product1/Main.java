package product1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				System.out.print("データベースにアクセスしたい場合は「1」、操作を終了したい場合は「0」を入力してください。:");

				String inputFunction = br.readLine();

				int selectFunction = Integer.parseInt(inputFunction);

				if (selectFunction == 1) {
					System.out.println("アクセスを開始します。\r\n");

					AccessDB ad = new AccessDB();
					ad.selectFunction();
				} else if (selectFunction == 0) {
					System.out.println("終了しました。");
					System.exit(0);
				} else {
					System.out.println("0,1以外の数字もしくは文字が入力されました。再度入力してください。\r\n");

				}
			}

		} catch (IOException e) {
			System.out.println("何らかのエラーが発生しました。");
		}
	}

}