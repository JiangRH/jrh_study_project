package com.initialjiang.guavastudy.utils;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

public class MyCommonUtils {
	
	private MyCommonUtils() { }

	/**
	 * 生成UUID
	 * @return uuid 字符串
	 */
	public static String generateUUID() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 格式化UUI，因为FS 发refer时，不能包含分号和等号
	 * @param uui
	 * @return
	 */
	public static String formatUUI(String uui) {
		uui = StringUtils.trimToEmpty(uui);
		return uui.replace(";", "%3B").replace("=", "%3D");
	}
	
	/**
	 * 将二进制数组转换成16进制
	 * @param byteArr
	 * @return
	 */
	public static String parseByte2HexStr(byte[] byteArr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteArr.length; i++) {
			String hex = Integer.toHexString(byteArr[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制数组
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

}
