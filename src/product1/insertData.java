package product1;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class insertData {
	private Connection con;

	public insertData(Connection con) {
		this.con = con;
	}

	public void insertSQL() {
		try {
			// テーブル指定
			BufferedReader br0 = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("追加したい食品の項目を選択してください。");
			System.out.print("鶏肉：1, 豚肉：２, 野菜：3, 魚（刺身）：4, 魚（切り身）, デザート：5, 調味料：6, 飲料：7");

			String tableName = br0.readLine();

			// 食品名の入力
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("追加したい食品名を入力してください。");

			String foodName = br1.readLine();

			// 価格の入力
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("食品の価格を入力してください");

			String inputPrice = br2.readLine();

			int foodPrice = Integer.parseInt(inputPrice);

			// 数量の入力
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("食品の数量を入力してください");

			String inputCounts = br3.readLine();

			int foodCounts = Integer.parseInt(inputCounts);

			// 期限の入力
			BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("賞味期限を入力してください（例：2024-12-31）:");

			String inputDate = br4.readLine();

			LocalDate expirationDate = null;

			try {
				expirationDate = LocalDate.parse(inputDate, DateTimeFormatter.ISO_LOCAL_DATE);
			} catch (DateTimeParseException e) {
				System.out.println("日付の形式が正しくありません。");
				return;
			}

			// SQL文を作成
			String SQL = "Insert into tableName = ? (foodName, foodPrice, foodCounts, foodExpirationDate)"
					+ "values (foodName = ?, foodPrice = ?, foodCounts = ?, foodExpirationDate = ?);";

			PreparedStatement ps = con.prepareStatement(SQL);

			ps.setString(1, tableName);

			ps.setString(2, foodName);

			ps.setInt(3, foodPrice);

			ps.setInt(4, foodCounts);

			Date sqlDate = Date.valueOf(expirationDate);

			ps.setDate(5, sqlDate);

			ps.executeUpdate();

			System.out.println("賞味期限が正常に挿入されました。");
		} catch (IOException e) {
			System.out.println("入出力に失敗しました。");
		} catch (SQLException e) {
			System.out.println("SQLエラーが発生しました。");
			e.printStackTrace();
		}
	}

}
