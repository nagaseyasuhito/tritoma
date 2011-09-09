package com.github.nagaseyasuhito.tritoma.persist.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.github.nagaseyasuhito.wigpa.persist.entity.BaseEntity;

@Entity
public class Task extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private Boolean completed;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date deadlineTimestamp;

	@Column(length = 8192)
	private CharSequence detail;

	@Column(nullable = false)
	private CharSequence subject;

	@ManyToOne(optional = false)
	private User user;

	public Date getDeadlineTimestamp() {
		return this.deadlineTimestamp;
	}

	public CharSequence getDetail() {
		return this.detail;
	}

	public CharSequence getSubject() {
		return this.subject;
	}

	public User getUser() {
		return this.user;
	}

	public Boolean isCompleted() {
		return this.completed;
	}

	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}

	public void setDeadlineTimestamp(Date deadlineTimestamp) {
		this.deadlineTimestamp = deadlineTimestamp;
	}

	public void setDetail(CharSequence detail) {
		this.detail = detail;
	}

	public void setSubject(CharSequence subject) {
		this.subject = subject;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
