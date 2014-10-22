package myeclipse.bookOnline.utils;

import java.util.UUID;

public class UUID_Util {

	public static String createID(){
		return UUID.randomUUID().toString();
	}
}
