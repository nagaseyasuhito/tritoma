package com.github.nagaseyasuhito.tritoma.wicket.page;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.link.Link;

import com.github.nagaseyasuhito.tritoma.persist.entity.Task;
import com.github.nagaseyasuhito.tritoma.wicket.TritomaSession;

@AuthorizeInstantiation({ "USER" })
public class IndexPage extends BasePage {
	private static final long serialVersionUID = 1L;

	public IndexPage() {
		this.add(new Link<Void>("createTask") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				Task task = new Task();
				task.setCompleted(false);
				task.setUser(TritomaSession.get().getUser());
				this.setResponsePage(new ModifyPage(task));
			}
		});
	}
}
