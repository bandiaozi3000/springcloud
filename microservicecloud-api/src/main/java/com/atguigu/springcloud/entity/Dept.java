package com.atguigu.springcloud.entity;


public class Dept {
	private Long deptNo;
	private String dname;
	private String db_source;
	public Long getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(Long deptNo) {
		this.deptNo = deptNo;
	}
	public String getDname() {
		return dname;
	}

	public Dept() {
	}

	public Dept(Long deptNo, String dname, String db_source) {
		super();
		this.deptNo = deptNo;
		this.dname = dname;
		this.db_source = db_source;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDb_source() {
		return db_source;
	}
	public void setDb_source(String db_source) {
		this.db_source = db_source;
	}

}
