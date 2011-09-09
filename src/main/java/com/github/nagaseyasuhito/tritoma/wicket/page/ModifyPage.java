package com.github.nagaseyasuhito.tritoma.wicket.page;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import com.github.nagaseyasuhito.tritoma.persist.dao.TaskDao;
import com.github.nagaseyasuhito.tritoma.persist.entity.Task;
import com.github.nagaseyasuhito.wigpa.wicket.WigpaWebApplication;
import com.google.inject.Inject;

@AuthorizeInstantiation({ "USER" })
public class ModifyPage extends BasePage {
	private static final long serialVersionUID = 1L;

	private Task task;

	@Inject
	private TaskDao taskDao;

	public ModifyPage(Task task) {
		this.task = task;

		Form<ModifyPage> modifyForm = new Form<ModifyPage>("modifyForm", new CompoundPropertyModel<ModifyPage>(this));
		modifyForm.add(new FeedbackPanel("feedback"));
		modifyForm.add(new TextField<CharSequence>("task.subject").setRequired(true));
		modifyForm.add(new TextArea<CharSequence>("task.detail"));
		modifyForm.add(new Button("submit") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				super.onSubmit();

				ModifyPage.this.task = ModifyPage.this.taskDao.persistOrMerge(ModifyPage.this.task);

				this.setResponsePage(WigpaWebApplication.get().getHomePage());
			}
		});
		this.add(modifyForm);
	}
}
