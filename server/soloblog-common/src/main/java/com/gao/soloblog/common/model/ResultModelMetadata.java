package com.gao.soloblog.common.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Metadata of ResultModel.
 * 
 */
public class ResultModelMetadata {

	public static final int TYPE_NULL = -1;
	public static final int TYPE_OBJECT = 0;
	public static final int TYPE_LIST = 1;
	public static final int TYPE_MAP = 2;

	protected int type = TYPE_OBJECT;

	protected Object clazz = null;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Object getClazz() {
		return clazz;
	}

	public void setClazz(Object clazz) {
		this.clazz = clazz;
	}

	public static ResultModelMetadata parse(Object model) {
		ResultModelMetadata metadata = new ResultModelMetadata();
		if (model == null) {
			metadata.setType(TYPE_NULL);
		} else if (Map.class.isAssignableFrom(model.getClass())) {
			Map<?, ?> modelMap = (Map<?, ?>) model;
			HashMap<String, String> clazzMap = new LinkedHashMap<String, String>();
			for (Entry<?, ?> entry : modelMap.entrySet()) {
				clazzMap.put(entry.getKey().toString(), entry.getValue()
						.getClass().getName());
			}
			metadata.type = TYPE_MAP;
			metadata.clazz = clazzMap;
		} else if (List.class.isAssignableFrom(model.getClass())) {
			List<?> modelList = (List<?>) model;
			ArrayList<String> clazzList = new ArrayList<String>();
			for (int i = 0; i < modelList.size(); i++) {
				clazzList.add(modelList.get(i).getClass().getName());
			}
			metadata.type = TYPE_LIST;
			metadata.clazz = clazzList;
		} else {
			metadata.type = TYPE_OBJECT;
			metadata.clazz = model.getClass().getName();
		}
		return metadata;
	}
}
