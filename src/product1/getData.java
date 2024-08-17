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
	private PreparedStatement ps;
	private ResultSet rs;

	public getData(Connection con, PreparedStatement ps, ResultSet rs) {
		this.con = con;
		this.ps = ps;
		this.rs = rs;
	}

	public void selectSQL() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("検索したい食品を入力してください。: ");

			String foodName = br.readLine();

			String getTableSQL = "select table_name from InforMation_schema.tables where table_schema = 'foods_in_refrigerator';";

			rs = ps.executeQuery(getTableSQL);

			List<String> tableNames = new ArrayList<>();

			while (rs.next()) {
				tableNames.add(rs.getString("table_name"));
			}

			for (String tableName : tableNames) {
				String SQL = "SELECT * FROM " + tableName + " WHERE column_name = " + foodName;
				;

				ps = con.prepareStatement(SQL);

				ps.setString(1, foodName);

				rs = ps.executeQuery();

				while (rs.next()) {
					System.out.println("食品名：" + rs.getString("name") + "　価格：" + rs.getInt("price")
							+ "　数量：" + rs.getInt("counts") + "　期限" + rs.getDate("expiration_date"));
				}
			}
		} catch (IOException e) {
			System.out.println("入出力に失敗しました。");
		} catch (SQLException e) {
			System.out.println("SQLエラーが発生しました。");
			e.printStackTrace();
		}

	}

}
