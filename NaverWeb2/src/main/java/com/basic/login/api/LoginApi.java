package com.basic.login.api;

import com.github.scribejava.core.builder.api.DefaultApi20;

public class LoginApi extends DefaultApi20 {

	protected LoginApi() {
	}

	private static class InstanceHolder {
		private static final LoginApi INSTANCE = new LoginApi();
	}

	public static LoginApi instance() {
		return InstanceHolder.INSTANCE;
	}

	@Override
	public String getAccessTokenEndpoint() {
		return "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code";
	}

	@Override
	protected String getAuthorizationBaseUrl() {
		return "https://nid.naver.com/oauth2.0/authorize";
	}
}