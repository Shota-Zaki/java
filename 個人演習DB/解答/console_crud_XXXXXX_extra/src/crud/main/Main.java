package crud.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import crud.db.DepartmentDAO;
import crud.db.EmployeeDAO;
import crud.util.DateUtil;
import crud.util.Department;
import crud.util.Employee;
import crud.util.ValidateUtil;

public class Main {
	/** 整数検証によるエラーメッセージ */
	public static final String TEXT_VALIDATION_ERROR_INTEGER = "%d以上%d以下の数値を入力してください：";

	/** 文字列検証によるエラーメッセージ */
	public static final String TEXT_VALIDATION_ERROR_STRING = "%d文字以上%d文字以下の文字列を入力してください：";

	/** 日付文字列検証によるエラーメッセージ */
	public static final String TEXT_VALIDATION_ERROR_DATE = "正しい形式(西暦年/月/日)で日付を入力してください：";

	public static void main(String[] args) throws IOException {
		/** 標準入力を受け取るためのオブジェクト */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int mode;

			System.out.print(
					"===社員管理システム===\n" +
							"1. 一覧表示\n" +
							"2. 社員名検索\n" +
							"3. 部署ID検索\n" +
							"4. 登録\n" +
							"5. 更新\n" +
							"6. 削除\n" +
							"7. 終了\n" +
							"メニュー番号を入力してください：");

			// 正しい数値が入力されるまで、入力を受け付ける
			while (true) {
				String input = in.readLine();
				if (ValidateUtil.inRange(input, 1, 7)) {
					mode = Integer.parseInt(input);
					break;
				}
				System.out.printf(TEXT_VALIDATION_ERROR_INTEGER, 1, 7);
			}

			if (mode == 1) {
				List<Employee> emps = EmployeeDAO.getAll();
				String result = "";

				// ヘッダー行を出力する
				result += "社員ID\t\t";
				result += "社員名\t\t";
				result += "性別\t";
				result += "生年月日\t";
				result += "部署名\n";

				// 各行を出力する
				for (Employee emp : emps) {
					String gender = "";
					String birthday = DateUtil.format(emp.getBirthday());

					if (emp.getGender() == 1) {
						gender = "男性";
					} else if (emp.getGender() == 2) {
						gender = "女性";
					}
					result += String.format("%-7d ", emp.getEmpId()) + "\t";
					result += emp.getEmpName() + "\t";
					result += gender + "\t";
					result += birthday + "\t";
					result += emp.getDept().getDeptName() + "\n";
				}
				System.out.println(result);

			} else if (mode == 2) {
				List<Employee> emps;
				String result = "";

				// 正しい文字列が入力されるまで、入力を受け付ける
				System.out.print("社員名を入力してください：");
				while (true) {
					String input = in.readLine();
					if (ValidateUtil.isNotBlank(input) &&
							ValidateUtil.isLengthBetween(input, 1, 30)) {
						emps = EmployeeDAO.getByEmpName(input);
						break;
					}
					System.out.printf(TEXT_VALIDATION_ERROR_STRING, 1, 30);
				}

				// ヘッダー行を出力する
				result += "社員ID\t\t";
				result += "社員名\t\t";
				result += "性別\t";
				result += "生年月日\t";
				result += "部署名\n";

				// 各行を出力する
				for (Employee emp : emps) {
					String gender = "";
					String birthday = DateUtil.format(emp.getBirthday());

					if (emp.getGender() == 1) {
						gender = "男性";
					} else if (emp.getGender() == 2) {
						gender = "女性";
					}
					result += String.format("%-7d ", emp.getEmpId()) + "\t";
					result += emp.getEmpName() + "\t";
					result += gender + "\t";
					result += birthday + "\t";
					result += emp.getDept().getDeptName() + "\n";
				}
				System.out.println(result);

			} else if (mode == 3) {
				List<Employee> emps;
				List<Department> depts = DepartmentDAO.getAll();
				String result = "";

				String deptMsg = "部署ID";
				boolean isFirst = true;

				// 出力用のメッセージを生成する
				deptMsg += "(";
				for (Department dept : depts) {
					if (isFirst) {
						isFirst = false;
					} else {
						deptMsg += "、";
					}
					deptMsg += dept.getDeptId() + "：" +
							dept.getDeptName();
				}
				deptMsg += ")を入力してください：";

				// 正しい数値が入力されるまで、入力を受け付ける
				System.out.print(deptMsg);
				while (true) {
					String input = in.readLine();
					if (ValidateUtil.inRange(input, 1, depts.size())) {
						emps = EmployeeDAO.getByEmpName(input);
						break;
					}
					System.out.printf(TEXT_VALIDATION_ERROR_INTEGER, 1, depts.size());
				}

				// ヘッダー行を出力する
				result += "社員ID\t\t";
				result += "社員名\t\t";
				result += "性別\t";
				result += "生年月日\t";
				result += "部署名\n";

				// 各行を出力する
				for (Employee emp : emps) {
					String gender = "";
					String birthday = DateUtil.format(emp.getBirthday());

					if (emp.getGender() == 1) {
						gender = "男性";
					} else if (emp.getGender() == 2) {
						gender = "女性";
					}
					result += String.format("%-7d ", emp.getEmpId()) + "\t";
					result += emp.getEmpName() + "\t";
					result += gender + "\t";
					result += birthday + "\t";
					result += emp.getDept().getDeptName() + "\n";
				}
				System.out.println(result);

			} else if (mode == 4) {
				Employee emp = new Employee();
				Department empDept = new Department();
				List<Department> depts = DepartmentDAO.getAll();

				String deptMsg = "部署ID";
				boolean isFirst = true;

				// 出力用のメッセージを生成する
				deptMsg += "(";
				for (Department dept : depts) {
					if (isFirst) {
						isFirst = false;
					} else {
						deptMsg += "、";
					}
					deptMsg += dept.getDeptId() + "：" +
							dept.getDeptName();
				}
				deptMsg += ")：";

				// 正しい文字列が入力されるまで、入力を受け付ける
				System.out.print("社員名：");
				while (true) {
					String input = in.readLine();
					if (ValidateUtil.isNotBlank(input)
							&& ValidateUtil.isLengthBetween(input, 1, 30)) {
						emp.setEmpName(input);
						break;
					}
					System.out.printf(TEXT_VALIDATION_ERROR_STRING, 1, 30);
				}

				// 正しい数値が入力されるまで、入力を受け付ける
				System.out.print("性別(1：男性、2：女性)：");
				while (true) {
					String input = in.readLine();
					if (ValidateUtil.inRange(input, 1, 2)) {
						emp.setGender(Integer.parseInt(input));
						break;
					}
					System.out.printf(TEXT_VALIDATION_ERROR_INTEGER, 1, 2);
				}

				// 正しい文字列が入力されるまで、入力を受け付ける
				System.out.print("生年月日(西暦年/月/日)：");
				while (true) {
					String input = in.readLine();
					if (ValidateUtil.isDate(input)) {
						emp.setBirthday(DateUtil.parse(input));
						break;
					}
					System.out.printf(TEXT_VALIDATION_ERROR_DATE);
				}

				// 正しい数値が入力されるまで、入力を受け付ける
				System.out.print(deptMsg);
				while (true) {
					String input = in.readLine();
					if (ValidateUtil.inRange(input, 1, depts.size())) {
						empDept.setDeptId(Integer.parseInt(input));
						emp.setDept(empDept);
						break;
					}
					System.out.printf(TEXT_VALIDATION_ERROR_INTEGER, 1, depts.size());
				}

				EmployeeDAO.create(emp);
				System.out.println("社員情報を登録しました");

			} else if (mode == 5) {
				Employee emp;
				Department empDept = new Department();
				List<Department> depts = DepartmentDAO.getAll();

				String deptMsg = "部署ID";
				boolean isFirst = true;

				// 出力用のメッセージを生成する
				deptMsg += "(";
				for (Department dept : depts) {
					if (isFirst) {
						isFirst = false;
					} else {
						deptMsg += "、";
					}
					deptMsg += dept.getDeptId() + "：" +
							dept.getDeptName();
				}
				deptMsg += ")：";

				// 正しい数値が入力されるまで、入力を受け付ける
				System.out.print("更新する社員の社員IDを入力してください：");
				while (true) {
					String input = in.readLine();
					if (ValidateUtil.inRange(input, 1, 9999)) {
						emp = EmployeeDAO.findByEmpId(Integer.parseInt(input));
						if (emp != null) {
							break;
						}
					}
					System.out.printf(TEXT_VALIDATION_ERROR_INTEGER, 1, 9999);
				}

				// 正しい文字列が入力されるまで、入力を受け付ける
				System.out.print("社員名：");
				while (true) {
					String input = in.readLine();
					if (!ValidateUtil.isNotBlank(input)) {
						break;
					} else if (ValidateUtil.isLengthBetween(input, 1, 30)) {
						emp.setEmpName(input);
						break;
					}
					System.out.printf(TEXT_VALIDATION_ERROR_STRING, 1, 30);
				}

				// 正しい数値が入力されるまで、入力を受け付ける
				System.out.print("性別(1：男性、2：女性)：");
				while (true) {
					String input = in.readLine();
					if (!ValidateUtil.isNotBlank(input)) {
						break;
					} else if (ValidateUtil.inRange(input, 1, 2)) {
						emp.setGender(Integer.parseInt(input));
						break;
					}
					System.out.printf(TEXT_VALIDATION_ERROR_INTEGER, 1, 2);
				}

				// 正しい文字列が入力されるまで、入力を受け付ける
				System.out.print("生年月日(西暦年/月/日)：");
				while (true) {
					String input = in.readLine();
					if (!ValidateUtil.isNotBlank(input)) {
						break;
					} else if (ValidateUtil.isDate(input)) {
						emp.setBirthday(DateUtil.parse(input));
						break;
					}
					System.out.printf(TEXT_VALIDATION_ERROR_DATE);
				}

				// 正しい数値が入力されるまで、入力を受け付ける
				System.out.print(deptMsg);
				while (true) {
					String input = in.readLine();
					if (!ValidateUtil.isNotBlank(input)) {
						break;
					} else if (ValidateUtil.inRange(input, 1, depts.size())) {
						empDept.setDeptId(Integer.parseInt(input));
						emp.setDept(empDept);
						break;
					}
					System.out.printf(TEXT_VALIDATION_ERROR_INTEGER, 1, depts.size());
				}

				EmployeeDAO.update(emp);
				System.out.println("社員情報を更新しました");

			} else if (mode == 6) {
				Employee emp = new Employee();

				// 正しい数値が入力されるまで、入力を受け付ける
				System.out.print("削除する社員の社員IDを入力してください：");
				while (true) {
					String input = in.readLine();
					if (ValidateUtil.inRange(input, 1, 9999)) {
						emp.setEmpId(Integer.parseInt(input));
						break;
					}
					System.out.printf(TEXT_VALIDATION_ERROR_INTEGER, 1, 9999);
				}

				EmployeeDAO.delete(emp);
				System.out.println("社員情報を削除しました");

			} else if (mode == 7) {
				System.out.println("システムを終了します");
				break;
			}
		}
	}
}
