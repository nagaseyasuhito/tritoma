package com.github.nagaseyasuhito.tritoma.wicket;

import javax.persistence.NoResultException;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.request.Request;

import com.github.nagaseyasuhito.tritoma.persist.dao.UserDao;
import com.github.nagaseyasuhito.tritoma.persist.entity.User;
import com.github.nagaseyasuhito.wigpa.wicket.WigpaWebSession;
import com.google.inject.Inject;

public class TritomaSession extends WigpaWebSession {
	private static final long serialVersionUID = 1L;

	public static TritomaSession get() {
		return (TritomaSession) AuthenticatedWebSession.get();
	}

	private Long id;

	@Inject
	private UserDao userDao;

	public TritomaSession(Request request) {
		super(request);
	}

	@Override
	public boolean authenticate(String mailAddress, String password) {
		try {
			this.id = this.userDao.findByMailAddressAndPassword(mailAddress, password).getId();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

	@Override
	public Roles getRoles() {
		if (this.isSignedIn()) {
			return new Roles("USER");
		}
		return null;
	}

	public User getUser() {
		if (!this.isSignedIn()) {
			return null;
		}

		return this.userDao.findById(this.id);
	}

	@Override
	public void signOut() {
		super.signOut();

		this.id = null;
	}
}
