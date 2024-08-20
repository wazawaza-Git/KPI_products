package product1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 
 */
public class AccessDB {
	// 定数を設定
	private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_CONNECTION = "jdbc:mysql://localhost:3306/foods_in_refrigerator";
	private static final String USER = "root";
	private static final String PASS = "pukupukuDB";

	public static Connection con = null;

	public AccessDB() {
	}

	public void selectFunction() {

		try {
			while (true) {
				// ～Dataクラスでクローズするため、whileの中
				Class.forName(MYSQL_DRIVER);

				con = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("希望する操作の番号を入力してください。");
				System.out.print("ホームに戻る：0, データ取得：1, データ追加：2, データ削除：3, データ更新：4, 期限アラート：5 | 番号 = ");

				String inputNumber = br.readLine();

				int number = Integer.parseInt(inputNumber);

				switch (number) {
				case 0:
					return;
				case 1:
					// データ取得
					System.out.println("データ取得を選択しました。\r\n");
					getData gd = new getData(con);
					gd.selectSQL();
					break;

				case 2:
					// データ追加
					insertData id = new insertData(con);
					id.insertSQL();
					break;

				case 3:
					// データ削除
					deleteData dd = new deleteData(con);
					dd.deleteSQL();
					break;

				case 4:
					// データ更新
					UpdateData ud = new UpdateData(con);
					ud.updateSQL();
					break;

				case 5:
					// 期限アラート
					InformDate Id = new InformDate(con);
					Id.alertDate();
					break;
				}
			}
		} catch (SQLException se) {
			System.out.println("データベース接続に失敗しました。");
			se.printStackTrace();
		} catch (ClassNotFoundException ce) {
			System.out.println("クラスの定義に失敗しました。");
			ce.printStackTrace();
		} catch (IOException e) {
			System.out.println("入出力操作に失敗しました。");
			e.printStackTrace();
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