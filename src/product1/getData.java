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

public class getData {
	private Connection con;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public getData(Connection con) {
		// Connectionインターフェースをメソッドで使用するため
		this.con = con;
	}

	public void selectSQL() {
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

					// カラム名を変数化している時はexecuteQuery()として引数にはSQLを設定しない？
					rs = ps.executeQuery();

					while (rs.next()) {
						System.out.println(
								"-----------------------------------------------------------------------------");
						System.out.println("テーブル名：" + tableName + "　食品名：" + rs.getString("foodName") + "　価格："
								+ rs.getInt("foodPrice")
								+ "　数量：" + rs.getInt("foodCounts") + "　期限：" + rs.getDate("foodExpirationDate"));
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
