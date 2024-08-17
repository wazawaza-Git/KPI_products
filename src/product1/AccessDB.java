package product1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;

	public AccessDB() {
	}

	public void selectFunction() {

		try {
			Class.forName(MYSQL_DRIVER);

			con = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);

			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("希望する操作の番号を入力してください。");
				System.out.print("ホームに戻る：0, データ取得：1, データ追加：2, データ削除：3, データ更新：4, 数量アラート：5, 期限アラート：6 | 番号 = ");

				String inputNumber = br.readLine();

				int number = Integer.parseInt(inputNumber);

				switch (number) {
				case 0:
					return;
				case 1:
					// データ取得
					getData gd = new getData(con, ps, rs);
					gd.selectSQL();
					break;

				case 2:
					// データ追加
					insertData id = new insertData(con);
					id.insertSQL();
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