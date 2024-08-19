package product1;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class deleteData {
	// AccessDBのconとの橋渡しのために宣言
	private Connection con = null;
	private PreparedStatement ps = null;

	public deleteData(Connection con) {
		// AccessDBのconをeleteDBクラスでも使用するため、引数（パラメータ）としてConnection con を設定
		// this.con(インスタンス変数)に引数を格納することで、このクラスでもAccessDBのconを使用できるようにしている。
		this.con = con;
	}

	public void deleteSQL() {
		try {
			// テーブル指定
			BufferedReader br0 = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("食品の項目を入力してください。");
			System.out.print("鶏肉, 豚肉, 野菜, 刺身, 魚, デザート, 調味料, 飲料：");

			String tableName = br0.readLine();

			// 削除データ指定
			BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("削除したい食品名を入力してください。：");

			String foodName = br1.readLine();

			// delete文作成
			String SQL = "delete from " + tableName + " where foodName = ?;";

			// SQL文をコンパイル（接続関係だからConnection下のメソッド）
			ps = con.prepareStatement(SQL);

			// プレースホルダーを設定 テーブル名は１度設定すると基本変更されないためプレースホルダーによる設定はせずとも直接SQLに組み込める
			ps.setString(1, foodName);

			int rowsCount = ps.executeUpdate();

			System.out.println(rowsCount + "件変更しました。");

		} catch (IOException e) {
			System.out.println("入出力に失敗しました。");
		} catch (SQLException se) {
			System.out.println("SQLエラーが発生しました。");
			se.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException se) {
				System.out.println("データベース接続の解除に失敗しました。");
				se.printStackTrace();
			}
		}
	}
}