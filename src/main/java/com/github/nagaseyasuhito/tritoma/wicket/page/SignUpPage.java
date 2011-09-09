package com.github.nagaseyasuhito.tritoma.wicket.page;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.EqualPasswordInputValidator;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import com.github.nagaseyasuhito.tritoma.persist.dao.UserDao;
import com.github.nagaseyasuhito.tritoma.persist.entity.User;
import com.github.nagaseyasuhito.wigpa.wicket.WigpaWebApplication;
import com.google.inject.Inject;

public class SignUpPage extends BasePage {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private String confirmPassword;

	private User user;

	@Inject
	private UserDao userDao;

	public SignUpPage() {
		this.user = new User();

		PasswordTextField userPasswordField, confirmPasswordField;

		Form<SignUpPage> signUpForm = new StatelessForm<SignUpPage>("signUpForm", new CompoundPropertyModel<SignUpPage>(this));
		signUpForm.add(new FeedbackPanel("feedback"));
		signUpForm.add(new TextField<CharSequence>("user.mailAddress").setRequired(true));
		signUpForm.add(userPasswordField = new PasswordTextField("user.password"));
		signUpForm.add(confirmPasswordField = new PasswordTextField("confirmPassword"));
		signUpForm.add(new Button("register") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				SignUpPage.this.userDao.persist(SignUpPage.this.user);
				this.setResponsePage(WigpaWebApplication.get().getHomePage());
			}
		});
		this.add(signUpForm);

		signUpForm.add(new EqualPasswordInputValidator(userPasswordField, confirmPasswordField));
	}
}
