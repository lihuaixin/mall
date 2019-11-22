package com.xxx.mall.utils;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;


/**
 *@desc: jasypt 加密，解密工具类
 *@date:  2018/7/10 15:49
 */
public class EncryptorUtil {
	
	private static final String KEY = "9FET6pBiQo7h2nUA6SAccrak9GB0/Nuwomw4u5Un56llsI3C1JiezTjhkPQk";

	/**
	 * 加密
	 * @param text 明文
	 * @return     密文
	 */
	public static String encrypt(String text) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(KEY);
		return encryptor.encrypt(text);
	}

	/**
	 * 解密
	 * @param cipherText 密文
	 * @return           明文
	 */
	public static String decrypt(String cipherText) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(KEY);
		return encryptor.decrypt(cipherText);
	}

	public static void main(String[] args) {
		String str = encrypt("Hello1234");
		System.out.println(str);
		String dec = decrypt(str);
		System.out.println(dec);
	}
}