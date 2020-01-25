package util;

import javax.servlet.http.HttpServletRequest;

public final class WebAlertViewer {
	
	public static void showAlertMessage(HttpServletRequest request, String message) {
		request.setAttribute("webAlertMessage", message);
		request.setAttribute("webAlertType", "info");
	}
	
	public static void showAlertMessage(HttpServletRequest request, String message, String type) {
		request.setAttribute("webAlertMessage", message);
		request.setAttribute("webAlertType", type);
	}
	
}
