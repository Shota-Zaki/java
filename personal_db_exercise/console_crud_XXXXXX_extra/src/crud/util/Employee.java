package crud.util;

import java.util.Date;

/**
 * 社員に関する情報を扱うためのクラスです。
 */
public class Employee {
	/** 社員ID */
	Integer empId;

	/** 社員名 */
	String empName;

	/** 性別 */
	Integer gender;

	/** 生年月日 */
	Date birthday;

	/** 部署情報 */
	Department dept;
	
	/**
	 * 空の社員オブジェクトを生成します。
	 */
	public Employee() {
		// none
	}
	
	/**
	 * 引数で初期化された社員オブジェクトを生成します。
	 * @param empId 社員ID
	 * @param empName 社員名
	 * @param gender 性別
	 * @param birthday 生年月日
	 * @param dept 部署情報
	 */
	public Employee(Integer empId, String empName, Integer gender, Date birthday, Department dept) {
		this.empId = empId;
		this.empName = empName;
		this.gender = gender;
		this.birthday = birthday;
		this.dept = dept;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}
}
