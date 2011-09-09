package com.github.nagaseyasuhito.tritoma.persist.dao.impl;

import com.github.nagaseyasuhito.tritoma.persist.dao.TaskDao;
import com.github.nagaseyasuhito.tritoma.persist.entity.Task;
import com.github.nagaseyasuhito.wigpa.persist.dao.impl.BaseDaoImpl;

public class TaskDaoImpl extends BaseDaoImpl<Task> implements TaskDao {

	@Override
	public Class<Task> getEntityClass() {
		return Task.class;
	}
}
