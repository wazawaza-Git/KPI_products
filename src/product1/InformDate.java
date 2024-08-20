package product1;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InformDate {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public InformDate(Connection con) {
		this.con = con;
	}

	public void alertDate() {
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				System.out.print("検索したい食品を入力してください。データ取得を終了したい場合は「nothing」を入力してください。: ");

				String foodName = br.readLine();

				if (foodName.equals("nothing")) {
					System.out.println("機能選択に戻ります。\\\\r\\\\n");
					break;
				}

				// テーブル名を取得するSQLを作成
				String getTableSQL = "show tables;";

				// SQL文をコンパイル
				ps = con.prepareStatement(getTableSQL);

				// SQLを実行し、結果を取得	
				rs = ps.executeQuery(getTableSQL);

				List<String> tableNames = new ArrayList<>();

				// 取得したテーブル名をリストに格納
				while (rs.next()) {
					tableNames.add(rs.getString(1));
				}

				for (String tableName : tableNames) {
					String SQL = "SELECT * FROM " + tableName + " WHERE foodName = ?";
					;

					// SQL文をコンパイル
					ps = con.prepareStatement(SQL);

					// プレースホルダーに入力した食品名を設定
					ps.setString(1, foodName);

					rs = ps.executeQuery();

					// SQL文から指定した食品の期限を取得できた場合
					if (rs.next()) {
						String dateString = rs.getString("foodExpirationDate");

						LocalDate dbDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

						LocalDate currentDate = LocalDate.now();

						if (dbDate.isAfter(currentDate)) {
							System.out.println("消費期限、もしくは賞味期限を超えています。");
						} else if (dbDate.isBefore(currentDate)) {
							System.out.println("超過していませんが、保存時の温度や湿度、残量に気を付けましょう。");
						} else {
							System.out.println("本日が消費期限、もしくは賞味期限です。生モノは優先して消費しましょう。");
						}
					}
					System.out.println("-----------------------------------------------------------------------------");
				}
			}
		} catch (IOException e) {
			System.out.println("入出力に失敗しました。");
		} catch (SQLException e) {
			System.out.println("SQLエラーが発生しました。");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("データベースのクローズに失敗しました。");
				e.printStackTrace();
			}
		}

	}

}
