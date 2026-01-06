package crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crud.util.Department;

/**
 * データベース上の部署に関する操作を行うためのクラスです。
 */
public class DepartmentDAO {

	/** 部署データ取得用のクエリ */
	public static final String SQL_GET_ALL = String.join("\n",
			"SELECT",
			"	dept_id,",
			"	dept_name",
			"FROM department");

	/** 部署データ取得用のクエリ */
	public static final String SQL_FIND_BY_DEPT_ID = String.join("\n",
			"SELECT",
			"	dept_id,",
			"	dept_name",
			"FROM department",
			"WHERE dept_id = ?");

	private DepartmentDAO() {
		// none
	}

	/**
	 * 全ての部署データを取得します。
	 * 
	 * @return 部署データを含むリスト
	 */
	public static List<Department> getAll() {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_GET_ALL)) {
			try (ResultSet rs = stmt.executeQuery()) {
				List<Department> depts = new ArrayList<>();
				while (rs.next()) {
					Department dept = new Department(
							rs.getInt("dept_id"),
							rs.getString("dept_name"));
					depts.add(dept);
				}
				return depts;
			}
		} catch (SQLException e) {
			// none
		}
		return null;
	}

	/**
	 * 部署IDの一致する部署データを取得します。
	 * 
	 * @param empId 検索対象の部署ID
	 * @return 一致する部署データ
	 */
	public static Department findByDeptId(int empId) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_FIND_BY_DEPT_ID)) {
			stmt.setInt(1, empId);
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					return new Department(
							rs.getInt("dept_id"),
							rs.getString("dept_name"));
				}
			}
		} catch (SQLException e) {
			// none
		}
		return null;
	}

}
