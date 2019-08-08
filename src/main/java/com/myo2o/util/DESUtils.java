package com.myo2o.util;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class DESUtils {

	private static Key key;
	private static String KEY_STR = "myKey";
	private static String CHARSETNAME = "UTF-8";
	private static String ALGORITHM = "DES/ECB/PKCS5Padding";

	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(KEY_STR.getBytes());
			generator.init(secureRandom);
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String getEncryptString(String str) {
		BASE64Encoder base64encoder = new BASE64Encoder();
		try {
			byte[] bytes = str.getBytes(CHARSETNAME);
			//任何加密解密算法都需要这个，通过工厂模式创建对象
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, key);//参数说明：加密模式，key秒
			byte[] doFinal = cipher.doFinal(bytes);
			return base64encoder.encode(doFinal);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}

//解密
	public static String getDecryptString(String str) {
		BASE64Decoder base64decoder = new BASE64Decoder();
		try {
			byte[] bytes = base64decoder.decodeBuffer(str);
			Cipher cipher = Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.DECRYPT_MODE, key);//解密模式
			byte[] doFinal = cipher.doFinal(bytes);
			return new String(doFinal, CHARSETNAME);
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getEncryptString("root"));
		System.out.println(getEncryptString(""));
	}

}


