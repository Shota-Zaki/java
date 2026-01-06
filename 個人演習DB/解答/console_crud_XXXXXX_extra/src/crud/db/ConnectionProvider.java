package crud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * データベースへの接続を行うためのユーティリティクラスです。
 */
public class ConnectionProvider {

	/** 接続先のURL */
	final private static String URL = "jdbc:mysql://localhost:3306/employee_manage";

	/** ユーザー名 */
	final private static String USER = "root";

	/** パスワード */
	final private static String PASSWORD = "root";

	private ConnectionProvider() {
		// none
	}

	/**
	 * Connectionオブジェクトを取得します。
	 * 
	 * @return Connectionオブジェクト
	 * @throws SQLException データベースへの接続に失敗した場合
	 */
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		return DriverManager.getConnection(URL, USER, PASSWORD);
	}

}
