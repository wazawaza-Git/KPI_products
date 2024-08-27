package javaQues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mondai204 {
	// 定数を設定
	private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_CONNECTION = "jdbc:mysql://localhost:3306/forjava";
	private static final String USER = "root";
	private static final String PASS = "pukupukuDB";

	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	public static void main(String[] args) {
		try {
			Class.forName(MYSQL_DRIVER);

			// DBに接続する
			con = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);

			String SQL = "select * from testtable;";

			st = con.prepareStatement(SQL);

			rs = st.executeQuery(SQL);

			while (rs.next()) {
				System.out.println("------------------------------------------------");
				System.out.println("商品番号：" + rs.getInt("productNumber") + "商品名：" + rs.getString("productNumber")
						+ "商品価格：" + rs.getInt("productPrice"));
				System.out.println("------------------------------------------------");
			}

		} catch (SQLException e) {
			System.out.println("データベース接続に失敗しました。");
			e.printStackTrace();
		} catch (ClassNotFoundException ce) {
			System.out.println("クラスの定義に失敗しました。");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (st != null) {
					st.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DB接続の終了に失敗しました。");
			}
		}

	}

}
