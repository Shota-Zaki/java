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

public class Main {
	public static void main(String[] args) throws IOException {
		/** 標準入力を受け取るためのオブジェクト */
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int mode;

			System.out.print(
					"===社員管理システム===\n" +
							"1. 一覧表示\n" +
							"2. 登録\n" +
							"3. 更新\n" +
							"4. 削除\n" +
							"5. 終了\n" +
							"メニュー番号を入力してください：");

			// 入力を受け付ける
			mode = Integer.parseInt(in.readLine());

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
				for (Employee employee : emps) {
					String gender = "";
					String birthday = DateUtil.format(employee.getBirthday());

					if (employee.getGender() == 1) {
						gender = "男性";
					} else if (employee.getGender() == 2) {
						gender = "女性";
					}
					result += String.format("%-7d ", employee.getEmpId()) + "\t";
					result += employee.getEmpName() + "\t";
					result += gender + "\t";
					result += birthday + "\t";
					result += employee.getDept().getDeptName() + "\n";
				}
				System.out.println(result);

			} else if (mode == 2) {
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

				// 入力を受け付ける
				System.out.print("社員名：");
				emp.setEmpName(in.readLine());

				// 入力を受け付ける
				System.out.print("性別(1：男性、2：女性)：");
				emp.setGender(Integer.parseInt(in.readLine()));

				// 入力を受け付ける
				System.out.print("生年月日(西暦年/月/日)：");
				emp.setBirthday(DateUtil.parse(in.readLine()));

				// 入力を受け付ける
				System.out.print(deptMsg);
				empDept.setDeptId(Integer.parseInt(in.readLine()));
				emp.setDept(empDept);

				EmployeeDAO.create(emp);
				System.out.println("社員情報を登録しました");

			} else if (mode == 3) {
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

				// 入力を受け付ける
				System.out.print("更新する社員の社員IDを入力してください：");
				emp.setEmpId(Integer.parseInt(in.readLine()));

				// 入力を受け付ける
				System.out.print("社員名：");
				emp.setEmpName(in.readLine());

				// 入力を受け付ける
				System.out.print("性別(1：男性、2：女性)：");
				emp.setGender(Integer.parseInt(in.readLine()));

				// 入力を受け付ける
				System.out.print("生年月日(西暦年/月/日)：");
				emp.setBirthday(DateUtil.parse(in.readLine()));

				// 入力を受け付ける
				System.out.print(deptMsg);
				empDept.setDeptId(Integer.parseInt(in.readLine()));
				emp.setDept(empDept);

				EmployeeDAO.update(emp);
				System.out.println("社員情報を更新しました");

			} else if (mode == 4) {
				Employee emp = new Employee();

				// 入力を受け付ける
				System.out.print("削除する社員の社員IDを入力してください：");
				emp.setEmpId(Integer.parseInt(in.readLine()));

				EmployeeDAO.delete(emp);
				System.out.println("社員情報を削除しました");

			} else if (mode == 5) {
				System.out.println("システムを終了します");
				break;
			}
		}
	}
}
