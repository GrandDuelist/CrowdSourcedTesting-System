package cn.com.crowdsourcedtesting.model;

public class GeneralHelperHandler {
	public boolean isPic(String type) {
		String[] pic = { "bmp", "png", "jpg", "jpeg", "gif" };
		for (String str : pic) {
			if (str.equalsIgnoreCase(type)) {
				return true;
			}
		}
		return false;
	}
}
