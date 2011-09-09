package com.github.nagaseyasuhito.tritoma.persist.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.github.nagaseyasuhito.wigpa.persist.entity.BaseEntity;
import com.google.common.collect.Lists;

@Entity
public class User extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false, unique = true)
	private CharSequence mailAddress;

	@Column(nullable = false)
	private CharSequence password;

	@OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Task> tasks = Lists.newArrayList();

	public CharSequence getMailAddress() {
		return this.mailAddress;
	}

	public CharSequence getPassword() {
		return this.password;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setMailAddress(CharSequence mailAddress) {
		this.mailAddress = mailAddress;
	}

	public void setPassword(CharSequence password) {
		this.password = password;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
