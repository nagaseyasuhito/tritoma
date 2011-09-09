package com.github.nagaseyasuhito.tritoma.persist.dao.impl;

import javax.persistence.NoResultException;

import com.github.nagaseyasuhito.tritoma.persist.dao.UserDao;
import com.github.nagaseyasuhito.tritoma.persist.entity.User;
import com.github.nagaseyasuhito.wigpa.persist.dao.impl.BaseDaoImpl;

public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User findByMailAddressAndPassword(String mailAddress, String password) {
		if (mailAddress == null || password == null) {
			throw new NoResultException();
		}

		User criteria = new User();
		criteria.setMailAddress(mailAddress);
		criteria.setPassword(password);
		return this.findByCriteria(criteria);
	}

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}
}
