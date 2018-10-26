package com.info.market.format;

public class FormatDataUtil {
	// ����һ���ַ��������д�д��ĸǰ����ո�
	public static String insertSpaceBeforeUpper(String source) {
		if (source == null || source.length() <= 1) {
			return source;
		}
		source.trim();
		char[] sourceChars = source.toCharArray();
		int count = 0;
		// �����д����(��������дǰ�пո���ַ�)
		for(int i = 1; i < sourceChars.length; i++) {
			if (sourceChars[i] >= 'A' && sourceChars[i] <= 'Z') {
				if (sourceChars[i-1] != ' ')
					count++;
			}
		}
		// ��ʽ��ȷ�򷵻�
		if (count == 0) return source;
		char[] destChars = new char[source.length()+count];
		destChars[0] = sourceChars[0];
		int destPosOff = 0;
		// ��Ŀ���ַ����鿽��Դ�ַ�����ͬʱ����ո�
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
