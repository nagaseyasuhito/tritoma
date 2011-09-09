package com.github.nagaseyasuhito.tritoma.persist.dao;

import com.github.nagaseyasuhito.tritoma.persist.dao.impl.TaskDaoImpl;
import com.github.nagaseyasuhito.tritoma.persist.entity.Task;
import com.github.nagaseyasuhito.wigpa.persist.dao.BaseDao;
import com.google.inject.ImplementedBy;

@ImplementedBy(TaskDaoImpl.class)
public interface TaskDao extends BaseDao<Task> {
}
