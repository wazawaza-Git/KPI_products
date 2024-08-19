package product1;

import java.sql.Connection;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpdateData {
	private Connection con = null;

	public UpdateData(Connection con) {
		this.con = con;
	}

	public void updateSQL() {
		try {
			while (true) {
				// テーブル指定
				BufferedReader br0 = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("食品の項目を入力してください。");
				System.out.print("鶏肉, 豚肉, 野菜, 刺身, 魚, デザート, 調味料, 飲料　");
				System.out.print("（データ取得を終了したい場合は「nothing」を入力してください。）：");

				String tableName = br0.readLine();

				if (tableName.equals("nothing")) {
					System.out.println("機能選択に戻ります。\\\\r\\\\n");
					break;
				}

				// 更新データ指定
				BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

				System.out.print("更新したい食品名を入力してください。：");

				String foodName = br1.readLine();

				BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("その食品のどの情報を更新しますか。希望する番号を入力してください。");
				System.out.print("価格：1, 数量：2, 期限：3　：　");

				String updateNumber = br2.readLine();

				switch (updateNumber) {
				case "1":
					UpdatePrice up = new UpdatePrice(con, tableName, foodName);
					up.updateSQL();
					break;

				case "2":
					UpdateCounts uc = new UpdateCounts(con, tableName, foodName);
					uc.updateSQL();
					break;

				case "3":
					UpdateExpirationDate ued = new UpdateExpirationDate(con, tableName, foodName);
					ued.updateSQL();
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("入出力に失敗しました。");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException se) {
				System.out.println("データベース接続の解除に失敗しました。");
				se.printStackTrace();
			}
		}
	}

}
