package cn.com.crowdsourcedtesting.model;

import java.net.HttpURLConnection;
import java.net.URL;

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

	public String isUrl(String webUrl) {
		URL url;
		try {
			url = new URL(webUrl);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			if (200 == connection.getResponseCode()) {
				return webUrl;
			}
		} catch (Exception e) {
			try {
				String newUrl = "http://" + webUrl;
				url = new URL(newUrl);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				if (200 == connection.getResponseCode()) {
					return newUrl;
				} else {
					return null;
				}
			} catch (Exception e1) {
			}
		}
		return null;
	}
}
