package product1;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class insertData {
	private Connection con;
	private PreparedStatement ps = null;

	public insertData(Connection con) {
		this.con = con;
	}

	public void insertSQL() {
		try {
			// テーブル指定
			BufferedReader br0 = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("追加したい食品の項目を入力してください。");
			System.out.print("鶏肉, 豚肉, 野菜, 刺身, 魚, デザート, 調味料, 飲料：");

			String tableName = br0.readLine();

			// 食品名の入力
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("追加したい食品名を入力してください。：");

			String foodName = br1.readLine();

			// 価格の入力
			BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("食品の単価を入力してください。(数字のみ入力)（パックや袋購入の場合は1パック、1袋単位で）：");

			String inputPrice = br2.readLine();

			int foodPrice = Integer.parseInt(inputPrice);

			// 数量の入力
			BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("食品の数量を入力してください。（数字のみ入力）（パックや袋購入の場合は1パック、1袋単位で）：");

			String inputCounts = br3.readLine();

			int foodCounts = Integer.parseInt(inputCounts);

			// 期限の入力
			BufferedReader br4 = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("賞味期限を入力してください（例：2024-09-25):");

			String foodExpirationDate = br4.readLine();

			// SQL文を作成 foodName = ?にするのは不要
			String SQL = "Insert into " + tableName
					+ " (foodName, foodPrice, foodCounts, foodExpirationDate) values (?, ?, ?, ?);";

			ps = con.prepareStatement(SQL);

			// 各プレースホルダーに入力値を設定
			ps.setString(1, foodName);

			ps.setInt(2, foodPrice);

			ps.setInt(3, foodCounts);

			ps.setString(4, foodExpirationDate);

			// SQLを実行し、その結果を取得する　ps.executeUpdate()は挿入件数を返す
			int rowsCount = ps.executeUpdate();

			System.out.println(rowsCount + "件変更しました。");

		} catch (IOException e) {
			System.out.println("入出力に失敗しました。");
		} catch (SQLException e) {
			System.out.println("SQLエラーが発生しました。");
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				System.out.println("データベースのクローズに失敗しました。");
				e.printStackTrace();
			}
		}
	}

}
