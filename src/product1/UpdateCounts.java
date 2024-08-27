package product1;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UpdateCounts {
	private Connection con = null;
	private PreparedStatement ps = null;
	private String tableName;
	private String foodName;

	public UpdateCounts(Connection con, String tableName, String foodName) {
		this.con = con;
		this.tableName = tableName;
		this.foodName = foodName;
	}

	public void updateSQL() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.print("更新後の数量を入力してください。（数字のみ入力）：");

			String inputCounts = br.readLine();

			int newCounts = Integer.parseInt(inputCounts);

			String SQL = "update " + tableName + " set foodCounts = ? where foodName = ?;";

			ps = con.prepareStatement(SQL);

			ps.setInt(1, newCounts);

			ps.setString(2, foodName);

			int rowsCount = ps.executeUpdate();

			System.out.println(rowsCount + "件変更しました。\\\\r\\\\n");
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
