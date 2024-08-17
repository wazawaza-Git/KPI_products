package product1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class inputExpirationDate {
	public inputExpirationDate() {
	}

	public static void inputDate() {
		try {
			// 年の入力
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("賞味期限、もしくは消費期限の年を入力してください。");

			String inputYear = br1.readLine();

			int year = Integer.parseInt(inputYear);

			// 月の入力
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("賞味期限、もしくは消費期限の月を入力してください。");

			String inputMonth = br2.readLine();

			int month = Integer.parseInt(inputMonth);

			// 日の入力
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("賞味期限、もしくは消費期限の日を入力してください。");

			String inputDay = br3.readLine();

			int day = Integer.parseInt(inputDay);

			// 日付の設定
			LocalDate expirationDate = LocalDate.of(year, month, day);

		} catch (IOException e) {
			System.out.println("入出力に失敗しました。");
		}

	}

}
