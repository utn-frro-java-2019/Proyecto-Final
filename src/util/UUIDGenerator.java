package util;

import java.util.UUID;

public class UUIDGenerator {

	public static String randomStringUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}