package javaQues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mondai207 {
	private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String JDBC_CONNECTION = "jdbc:mysql://localhost:3306/forjava";
	private static final String USER = "root";
	private static final String PASS = "pukupukuDB";

	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	public static void main(String[] args) {
		BufferedReader br1 = null;
		BufferedReader br2 = null;
		BufferedReader br3 = null;
		BufferedReader br4 = null;

		try {
			Class.forName(MYSQL_DRIVER);

			con = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);

			br1 = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("テーブル名を入力してくださいーー＞");

			String tableName = br1.readLine();

			br2 = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("更新する行の商品番号を入力してくださいーー＞");

			String inputNumber = br2.readLine();

			int productNumber = Integer.parseInt(inputNumber);

			br3 = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("更新後の商品名を入力してくださいーー＞");

			String productName = br3.readLine();

			br4 = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("更新後の商品価格を入力してくださいーー＞");

			String inputPrice = br4.readLine();

			int productPrice = Integer.parseInt(inputPrice);

			String SQL = "Update " + tableName + " set productName = ?, productPrice = ? where productNumber = ?;";

			ps = con.prepareStatement(SQL);

			ps.setString(1, productName);

			ps.setInt(2, productPrice);

			ps.setInt(3, productNumber);

			int countRow = ps.executeUpdate();

			System.out.println(countRow + "件更新されました。");

		} catch (SQLException se) {
			System.out.println("DBの接続に失敗しました。");
		} catch (ClassNotFoundException ce) {
			System.out.println("クラスの定義に失敗しました。");
		} catch (IOException e) {
			System.out.println("入力操作に失敗しました。");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException se) {
				System.out.println("データベースのクローズに失敗しました。");
				se.printStackTrace();
			}
		}

	}

}
