package crud.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crud.util.Department;
import crud.util.Employee;

/**
 * データベース上の社員に関する操作を行うためのクラスです。
 */
public class EmployeeDAO {

	/** 社員データ登録用のクエリ */
	public static final String SQL_CREATE = String.join("\n",
			"INSERT INTO employee (",
			"	emp_name,",
			"	gender,",
			"	birthday,",
			"	dept_id",
			") VALUES (",
			"	?,",
			"	?,",
			"	?,",
			"	?",
			")");

	/** 全社員データ取得用のクエリ */
	public static final String SQL_GET_ALL = String.join("\n",
			"SELECT",
			"	emp_id,",
			"	emp_name,",
			"	gender,",
			"	birthday,",
			"	department.dept_id,",
			"	dept_name",
			"FROM employee",
			"INNER JOIN department",
			"	ON employee.dept_id = department.dept_id",
			"ORDER BY emp_id");

	/** 社員データ更新用のクエリ */
	public static final String SQL_UPDATE = String.join("\n",
			"UPDATE employee SET",
			"	emp_name = ?,",
			"	gender = ?,",
			"	birthday = ?,",
			"	dept_id = ?",
			"WHERE emp_id = ?");

	/** 社員データ削除用のクエリ */
	public static final String SQL_DELETE = String.join("\n",
			"DELETE FROM employee",
			"WHERE emp_id = ?");

	private EmployeeDAO() {
		// none
	}

	/**
	 * 社員データを登録します。
	 * 
	 * @param emp 社員データ
	 * @return クエリの実行結果
	 */
	public static boolean create(Employee emp) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_CREATE)) {
			stmt.setString(1, emp.getEmpName());
			stmt.setInt(2, emp.getGender());
			stmt.setDate(3, new Date(emp.getBirthday().getTime()));
			stmt.setInt(4, emp.getDept().getDeptId());
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// none
		}
		return false;
	}

	/**
	 * 全ての社員データを取得します。
	 * 
	 * @return 社員データを含むリスト
	 */
	public static List<Employee> getAll() {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_GET_ALL)) {
			try (ResultSet rs = stmt.executeQuery()) {
				List<Employee> emps = new ArrayList<>();
				while (rs.next()) {
					Department dept = new Department(
							rs.getInt("dept_id"),
							rs.getString("dept_name"));
					Employee emp = new Employee(
							rs.getInt("emp_id"),
							rs.getString("emp_name"),
							rs.getInt("gender"),
							rs.getDate("birthday"),
							dept);
					emps.add(emp);
				}
				return emps;
			}
		} catch (SQLException e) {
			// none
		}
		return null;
	}

	/**
	 * 社員データを更新します。
	 * 
	 * @param emp 社員データ
	 * @return クエリの実行結果
	 */
	public static boolean update(Employee emp) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE)) {
			stmt.setString(1, emp.getEmpName());
			stmt.setInt(2, emp.getGender());
			stmt.setDate(3, new Date(emp.getBirthday().getTime()));
			stmt.setInt(4, emp.getDept().getDeptId());
			stmt.setInt(5, emp.getEmpId());
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// none
		}
		return false;
	}

	/**
	 * 社員データをemployeeテーブルから削除します。
	 * 
	 * @param emp 社員データ
	 * @return クエリの実行結果
	 */
	public static boolean delete(Employee emp) {
		try (Connection conn = ConnectionProvider.getConnection();
				PreparedStatement stmt = conn.prepareStatement(SQL_DELETE)) {
			stmt.setInt(1, emp.getEmpId());
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			// none
		}
		return false;
	}

}
