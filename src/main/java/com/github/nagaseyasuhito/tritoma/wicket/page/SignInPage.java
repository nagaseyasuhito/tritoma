package com.github.nagaseyasuhito.tritoma.wicket.page;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.ValidationError;

import com.github.nagaseyasuhito.wigpa.wicket.WigpaWebSession;

public class SignInPage extends BasePage {
	private static final long serialVersionUID = 1L;

	private CharSequence mailAddress;

	private CharSequence password;

	public SignInPage() {
		this.add(new Link<Void>("signUp") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				this.setResponsePage(new SignUpPage());
			}
		});
		Form<SignInPage> signInForm = new StatelessForm<SignInPage>("signInForm", new CompoundPropertyModel<SignInPage>(this));
		signInForm.add(new FeedbackPanel("feedback"));
		signInForm.add(new TextField<CharSequence>("mailAddress").setRequired(true));
		signInForm.add(new PasswordTextField("password"));
		signInForm.add(new Button("signIn") {
			private static final long serialVersionUID = 1L;

			@Override
			public void onSubmit() {
				if (WigpaWebSession.get().signIn(SignInPage.this.mailAddress, SignInPage.this.password)) {
					if (!this.continueToOriginalDestination()) {
						this.setResponsePage(Application.get().getHomePage());
					}
				} else {
					this.error(new ValidationError().addMessageKey("signInFailed"));
				}
			}
		});
		this.add(signInForm);
	}
}
