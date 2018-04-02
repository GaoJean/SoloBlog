package com.gao.soloblog.common.model;

public class ResultModel {


	protected int code = 0;
	protected String description = null;
	protected Object model = null;

	protected ResultModelMetadata metadata = null;

	public ResultModel() {
		this(0, null, null);
	}

	public ResultModel(Object value) {
		this(0, null, value);
	}

	public ResultModel(int code, String description) {
		this(code, description, null);
	}

	public ResultModel(int code, String description, Object value) {
		super();
		this.code = code;
		this.description = description;
		this.model = value;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}

	public ResultModelMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(ResultModelMetadata metadata) {
		this.metadata = metadata;
	}


}
