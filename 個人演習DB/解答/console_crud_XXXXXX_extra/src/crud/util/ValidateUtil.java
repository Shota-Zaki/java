package crud.util;

/**
 * バリデーションに必要なメソッドを提供するユーティリティクラスです。
 */
public class ValidateUtil {

	private ValidateUtil() {
		// none
	}

	/**
	 * 指定された文字列が Date型 に変換可能であるかを判定します。
	 *
	 * @param s 判定対象の文字列
	 * @return 文字列が Date型 に変換可能である場合は true、
	 * 		そうでない場合は true
	 */
	public static boolean isDate(String s) {
		return DateUtil.parse(s) != null;
	}

	/**
	 * 指定された文字列が int 型に変換可能であるかを判定します。
	 *
	 * @param s 判定対象の文字列
	 * @return 文字列が int 型に変換可能である場合は true、
	 * 		そうでない場合は false
	 */
	public static boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 指定された文字列が null ではなく、かつ空白文字のみで構成されていないかどうかを判定します。
	 *
	 * @param s 判定対象の文字列
	 * @return 文字列が非 null かつ空白文字のみで構成されていない場合は true、
	 * 		そうでない場合は false
	 */
	public static boolean isNotBlank(String s) {
		return s != null && !s.isBlank();
	}

	/**
	 * 指定された文字列が、整数に変換可能かつ start 以上 end 以下であるかどうかを判定します。
	 *
	 * @param num 判定対象の文字列
	 * @return 文字列が整数に変換可能かつ start 以上 end 以下である場合は true、
	 * 		そうでない場合は false
	 */
	public static boolean inRange(String s, int start, int end) {
		return isInteger(s) && inRange(Integer.parseInt(s), start, end);
	}

	/**
	 * 指定された整数が、start 以上 end 以下であるかどうかを判定します。
	 *
	 * @param num 判定対象の整数
	 * @return 整数が start 以上 end 以下である場合は true、
	 * 		そうでない場合は false
	 */
	public static boolean inRange(int num, int start, int end) {
		return start <= num && num <= end;
	}

	/**
	 * 指定された文字列の長さが、max 以下であるかどうかを判定します。
	 *
	 * @param num 判定対象の整数
	 * @return 文字列の長さが max 以下である場合は true、
	 * 		そうでない場合は false
	 */
	public static boolean isLengthBetween(String s, int min, int max) {
		return s != null &&
				min <= s.length() && s.length() <= max;
	}

}
