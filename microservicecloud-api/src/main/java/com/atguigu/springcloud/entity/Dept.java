package com.atguigu.springcloud.entity;


public class Dept {
	private Long deptNo;
	private String dName;
	private String dbSource;
	public Long getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Long deptNo) {
		this.deptNo = deptNo;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getDbSource() {
		return dbSource;
	}

	public void setDbSource(String dbSource) {
		this.dbSource = dbSource;
	}

	@Override
	public String toString() {
		return "Dept{" +
				"deptNo=" + deptNo +
				", dName='" + dName + '\'' +
				", dbSource='" + dbSource + '\'' +
				'}';
	}
}
