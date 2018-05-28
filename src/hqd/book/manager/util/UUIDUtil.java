package hqd.book.manager.util;

import java.util.UUID;

/**
 * 生成32为16进制随机数
 * @author hqd
 *
 */
public class UUIDUtil {

	public static String getUUID() {
		UUID id = UUID.randomUUID();
		return id.toString().replaceAll("-", "");
	}
	
}
