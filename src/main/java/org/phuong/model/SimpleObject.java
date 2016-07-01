package org.phuong.model;

import javax.annotation.security.RolesAllowed;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "simple_object")
public class SimpleObject {

	private Integer id;
	private String name;
	private String msg;

	public SimpleObject() {
		super();
	}

	public SimpleObject(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SimpleObject(Integer id, String name, String msg) {
		super();
		this.id = id;
		this.name = name;
		this.msg = msg;
	}

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@RolesAllowed("admin")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
