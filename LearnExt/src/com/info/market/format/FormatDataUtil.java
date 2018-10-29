package com.info.market.format;

import org.eclipse.jdt.internal.compiler.ast.NullLiteral;

import com.alibaba.druid.sql.visitor.functions.Trim;
import com.fasterxml.jackson.databind.ObjectMapper;

/* This class provides some function to format the data.
 * @author YeungSui
 * @version 0.1
 */
public class FormatDataUtil {
	/* Insert space before every upper case characters except the very first character of the source string
	 * @author YeungSui
	 * @version 0.2
	 * @param source the source string
	 * @return the formatted string
	 */
	public static String insertSpaceBeforeUpper(String source) {
		if (source == null || source.length() <= 1) {
			return source;
		}
		source.trim();
		char[] sourceChars = source.toCharArray();
		char[] destChars = new char[source.length()*2-1];
		int destPosOff = 0;
		/* copy source string to destination string  */
		for(int i = 1; i < sourceChars.length; i++) {
			if (sourceChars[i] >= 'A' && sourceChars[i] <= 'Z') {
				if (sourceChars[i-1] != ' ')
					destChars[i+destPosOff++] = ' ';
			}
			destChars[i+destPosOff] = sourceChars[i];
		}
		/* fill the rest of buffer with whitespace  */
		for (int i = sourceChars.length; i < 2*source.length()-1; i++) {
			destChars[i] = ' ';
		}
		return String.valueOf(destChars).trim();
	}
	/* get select statement without conditions
	 * @param fields specified the query fields
	 * @return assembled select statement
	 */
	public static String getSelectAllStatement(String[] fields, String tableName) {
		if (fields == null || fields.length == 0) {
			return "select * from " + tableName;
		}
		StringBuilder strb = new StringBuilder("select ");
		for (String field:fields) {
			strb.append(field).append(",");
		}
		strb.setCharAt(strb.length()-1, ' ');
		strb.append("from ").append(tableName);
		return strb.toString();
	}
}
