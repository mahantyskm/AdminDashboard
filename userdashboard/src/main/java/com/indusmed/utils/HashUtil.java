package com.indusmed.utils;

import java.security.MessageDigest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class HashUtil {

	private static final Logger LOGGER = Logger.getLogger(HashUtil.class);
	@Autowired
	static MessageDigest messageDigest;

	public static String getSHA256Hash(String password) {
		messageDigest.update(password.getBytes());
		byte[] byteData = messageDigest.digest();
		StringBuffer sb = new StringBuffer();
		sb.append("{SHA:256}:");
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		LOGGER.info("Generating Hash ...");
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Generated hash : " + sb.toString());
		}
		return sb.toString();
	}
}
