package com.github.nagaseyasuhito.tritoma.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;

import com.github.nagaseyasuhito.tritoma.wicket.page.IndexPage;
import com.github.nagaseyasuhito.tritoma.wicket.page.SignInPage;
import com.github.nagaseyasuhito.wigpa.wicket.WigpaWebApplication;

public class TritomaWebApplication extends WigpaWebApplication {

	@Override
	public Class<? extends Page> getHomePage() {
		return IndexPage.class;
	}

	@Override
	public CharSequence getJpaUnitName() {
		return "default";
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return SignInPage.class;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		return TritomaSession.class;
	}

	@Override
	protected void init() {
		super.init();

		this.mountPage("/signIn", SignInPage.class);
	}
}
