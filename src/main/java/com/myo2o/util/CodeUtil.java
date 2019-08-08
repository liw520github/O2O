package com.myo2o.util;

import javax.servlet.http.HttpServletRequest;

public class CodeUtil {
	public static boolean checkVerifyCode(HttpServletRequest request) {
		String verifyCodeExpected = (String) request.getSession()
				.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		String verfiCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual").toUpperCase();
		if (verfiCodeActual == null || !verfiCodeActual.equals(verifyCodeExpected)) {
			return false;

		}
		return true;
	}

}
