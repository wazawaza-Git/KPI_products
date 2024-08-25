package product1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.FileWriter;

public class ShoppingList {
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public ShoppingList(Connection con) {
		this.con = con;
	}

	public void makeList() {
		try {
			// アラートチェックを行う（特定のレコードではなく、全レコードに対して）
			// アラートにかかった食品のみメモに書き出す
			// SQL文を作成し実行→SQLの結果をオブジェクトに格納→ファイルを用意→結果を記載メソッドの引数に設定→ファイル出力
			//
			
		} catch (){
			
			
		} finally {
			
		}
	}

}
