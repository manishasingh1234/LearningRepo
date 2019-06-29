package com.pojo;

import java.io.Serializable;

public class ProjectId implements Serializable{
	
	
	/**
	 * 
	 */
	private int projectId;
	
	private int depId;
	private static final long serialVersionUID = 1L;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}


}
