package org.fb.utils;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;

/**
 * AES 是一种可逆加密算法，对用户的敏感信息加密处理 对原始数据进行AES加密后，在进行Base64编码转化；
 */
public class AESOperator {
	/*
	 * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
	 */
	//private String sKey = "0123456789abcdef";
	//private String ivParameter = "0123456789abcdef";
	
	private static byte[] keys  = { 0x7e,(byte) 0x9f,(byte) 0xd1,(byte) 0x92,(byte) 0xc8,(byte) 0xf5,0x0c,(byte) 0xb2,
		   0x21,(byte) 0x9b,0x32,0x59,(byte) 0x92,(byte) 0xc8,(byte) 0xc5,0x0c,
		  (byte) 0xa2,(byte) 0x9f,(byte) 0xd1,(byte) 0x92,(byte) 0xc8,(byte) 0xf5,0x3c,0x37,
		  (byte) 0xbe,(byte) 0xcf,(byte) 0xd4,(byte) 0x96,0x70,0x0f,0x0c,0x61};
	
	private static byte[] iv_byte =  {5,6,2,1,4,5,6,7,8,7,2,11,2,13,9,0};
	
	
	private static AESOperator instance = null;

	private AESOperator() {

	}

	public static AESOperator getInstance() {
		if (instance == null)
			instance = new AESOperator();
		return instance;
	}

	// 加密
	public static String encrypt(String pwd) throws Exception {
		 byte[] pas  =new byte[] {
				 pwd.getBytes()[0], pwd.getBytes()[1], pwd.getBytes()[2], pwd.getBytes()[3], pwd.getBytes()[4],pwd.getBytes()[5],
				0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
		byte[] raw = keys;//sKey.getBytes();
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		IvParameterSpec iv = new IvParameterSpec(iv_byte);//ivParameter.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
		byte[] encrypted = cipher.doFinal(pas);
		
		return  printHexString(encrypted);//此处使用BASE64做转码。
	}
	
	// 解密
	public String decrypt(String sSrc) throws Exception {
		try {
			byte[] raw = keys;//sKey.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");//PKCS5Padding");
			IvParameterSpec iv = new IvParameterSpec(iv_byte);//ivParameter.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
			byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);//先用base64解密
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original); 
					
			return originalString;
		} catch (Exception ex) {
		return null;
		}
	}

	public static String printHexString( byte[] b) { 
		  String result="";
		     for (int i = 0; i < b.length; i++) { 
		       String hex = Integer.toHexString(b[i] & 0xFF); 
		       if (hex.length() == 1) { 
		         hex = '0' + hex; 
		       } 
		       result=result+hex.toUpperCase(); 
		     } 
		     return result;
		 }

		public static byte[] hexStringToBytes(String hexString) {    
		   if (hexString == null || hexString.equals("")) {    
		       return null;    
		   }    
		   hexString = hexString.toUpperCase();    
		   int length = hexString.length() / 2;    
		   char[] hexChars = hexString.toCharArray();    
		   byte[] d = new byte[length];    
		   for (int i = 0; i < length; i++) {    
		       int pos = i * 2;    
		       d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]));    
		   }    
		   return d;    
		}  

		private static byte charToByte(char c) {    
		   return (byte) "0123456789ABCDEF".indexOf(c);    
		}   
}
