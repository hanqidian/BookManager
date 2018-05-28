package hqd.book.manager.util;
/**
 * 字符串工具类
 * @author hqd
 *
 */
public class StringUtil {

	/**
	 * 判断是否为空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str == null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 判断是否非空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str){
		if(str != null && !"".equals(str)) {
			return true;
		}else {
			return false;
		}
	}
	
}
