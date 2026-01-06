package crud.util;

/**
 * 部署に関する情報を扱うためのクラスです。
 */
public class Department {
	/** 部署ID */
	Integer deptId;

	/** 部署名 */
	String deptName;
	
	/**
	 * 空の部署オブジェクトを生成します。
	 */
	public Department() {
		// none
	}
	
	/**
	 * 引数で初期化された部署オブジェクトを生成します。
	 * @param deptId 部署ID
	 * @param deptName 部署名
	 */
	public Department(Integer deptId, String deptName) {
		this.deptId = deptId;
		this.deptName = deptName;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
