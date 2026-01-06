package crud.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日付と文字列の相互変換に必要なメソッドを提供するユーティリティクラスです。
 */
public class DateUtil {

	/** 文字列を解析する為のパターン */
	private static final SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

	/** Date オブジェクトをフォーマットする為のパターン */
	private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");

	private DateUtil() {
		// none
	}

	/**
	 * yyyy/MM/dd 形式の文字列を解析し、Date型に変換します。
	 * 
	 * @param s yyyy/MM/dd 形式の文字列
	 * @return 文字列から変換された Date オブジェクト<br>
	 * 		解析不可能な場合は null
	 */
	public static Date parse(String s) {
		try {
			return parser.parse(s);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * Date型を yyyy-MM-dd 形式の文字列にフォーマットします。
	 * 
	 * @param date 文字列にフォーマットする Date オブジェクト
	 * @return Date オブジェクトから変換された文字列
	 */
	public static String format(Date date) {
		return formatter.format(date);
	}

}
