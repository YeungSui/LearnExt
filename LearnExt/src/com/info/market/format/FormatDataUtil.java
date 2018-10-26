package com.info.market.format;

public class FormatDataUtil {
	// 除第一个字符以外所有大写字母前插入空格
	public static String insertSpaceBeforeUpper(String source) {
		if (source == null || source.length() <= 1) {
			return source;
		}
		source.trim();
		char[] sourceChars = source.toCharArray();
		int count = 0;
		// 计算大写个数(不包括大写前有空格的字符)
		for(int i = 1; i < sourceChars.length; i++) {
			if (sourceChars[i] >= 'A' && sourceChars[i] <= 'Z') {
				if (sourceChars[i-1] != ' ')
					count++;
			}
		}
		// 格式正确则返回
		if (count == 0) return source;
		char[] destChars = new char[source.length()+count];
		destChars[0] = sourceChars[0];
		int destPosOff = 0;
		// 向目标字符数组拷贝源字符串，同时插入空格
		for (int i = 1; i < source.length(); i++) {
			if (sourceChars[i] <= 'Z' && sourceChars[i] >= 'A') {
				if (sourceChars[i-1] != ' ')
					destChars[i+destPosOff++] = ' ';
			}
			destChars[i+destPosOff] = sourceChars[i];
		}
		return String.valueOf(destChars);
	}
	
}
