
package org.fb.utils;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;

import sun.misc.BASE64Decoder;



/**
 * 安全处理相关功能
 */
public class SecurityUtil {
  //对称加密默认密钥
//  private static byte[] keyb = {11, 105, -119, 50, 4, -105, 16, 38, -14, -111, 21, -95, 70, -15, 76,-74};
	
	/**
	 * Verify if a byte[]'s HASH value is equals the specified one.
	 * 
	 * @param aAlgorithm Message digest algorithm
	 * @param aTobeVerified 
	 * @param aHashArray
	 * 
	 * @return boolean if equals, return true, otherwise, return false.
	 */
	public static boolean verifyHash(String aAlgorithm, byte[] aTobeVerified, byte[] aHashArray) throws Exception{
		byte[] tHashValue = hash(aAlgorithm, aTobeVerified);
		String tHashValueStr = Base64.encode(tHashValue);
		String tHashArrayStr = Base64.encode(aHashArray);
		if (tHashValueStr.equals(tHashArrayStr)){
			return true;
		}
		return false;
	}
	
    /**
     * 根据指定的算法，计算传入数据的摘要值
     * 
     * @param aAlgorithm 摘要算法
     * @param aByteArray 需要计算摘要的数据
     * @return 摘要值
     * @throws NoSuchAlgorithmException 
     */
    public static byte[] hash(String aAlgorithm, byte[] aByteArray) throws Exception {
        MessageDigest md = MessageDigest.getInstance(aAlgorithm);
        md.update(aByteArray);
        return md.digest();
    }

	/**
	 * 根据指定的算法，计算传入数据的摘要值
	 * 
	 * @param aAlgorithm 摘要算法
	 * @param aByteArray 需要计算摘要的数据
	 * @return String 摘要值
	 * @throws NoSuchAlgorithmException 
	 */
	public static String hashWithBase64Encoded(String aAlgorithm, byte[] aByteArray) throws Exception {
		return Base64.encode(hash(aAlgorithm, aByteArray));
	}
    
    /**建行专用对MAC压码后的字符进行显示方式的转化<br>
     * 1、对128位的交易结果按4位为一个单位进行划分，共获得32段<br>
     * 2、将每段看成一个16进制数，如0011为0X3，1101为0Xd。<br>
     * 3、将这个数映射到ASCII码表，形成相应的字符，如0X2为“2”，0Xd为“d”。<br>
     * 4、将这些字符连成一个字符串，长度为32。
     * @param aAlgorithm 摘要算法
     * @param aByteArray 需要计算摘要的数据
     * @return String 摘要值
     * @throws Exception
     */
    public static String hashWithCCB(String aAlgorithm, byte[] aByteArray) throws Exception {
        int len,i;
        byte tb;
        char high,tmp,low;
        byte[] aMACByteArray = hash(aAlgorithm, aByteArray);
        String result=new String();
        len=aMACByteArray.length;
        for(i=0;i<len;i++)
        {
            tb=aMACByteArray[i];
            
            tmp=(char)((tb>>>4)&0x000f);
            if(tmp>=10)
                high=(char)('a'+tmp-10);
            else
                high=(char)('0'+tmp);
            result+=high;
            tmp=(char)(tb&0x000f);
            if(tmp>=10)
                low=(char)('a'+tmp-10);
            else
                low=(char)('0'+tmp);
            
            result+=low;
        }
        return result;

    }

	/**
	 * 使用软件签名
	 * @param toSignDate 被签名的数据
	 * @param signatureAlgo 签名算法
	 * @param privateKey 签名私钥
	 * @return String 签名后Base64编码后的字符串
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchProviderException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 */
	public static String softSignAndBase64Encode(byte[] toSignDate, String signatureAlgo, PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException{
		String tResult = null;
		java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		byte[] tByte;
		Signature signature = Signature.getInstance(signatureAlgo,"BC");
		signature.initSign(privateKey);
		signature.update(toSignDate);
		tByte = signature.sign();
		tResult = Base64.encode(tByte);
		return tResult;
	}

	/**
	 * 使用软件签名
	 * @param aPrivateKey
	 * @param aData the byte array to use for the update.
	 * @param aAlgorithm the name of the algorithm requested.
	 * 
	 * @return the signature bytes of the signing operation's result.
	 * 
	 * @throws GeneralSecurityException
	 */
	public static byte[] softSign(byte[] aData, String aAlgorithm, PrivateKey aPrivateKey) throws SignatureException, InvalidKeyException, NoSuchAlgorithmException, NoSuchProviderException{
		java.security.Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		Signature tSignature = Signature.getInstance(aAlgorithm, "BC");
		tSignature.initSign(aPrivateKey);
		tSignature.update(aData);
		byte[] tResult = tSignature.sign();

		return tResult;
	}


	/**
	 * 
	 * @Title: base64dec
	 * @Description:  解析base64
	 * @author yang_df
	 * @since 2014年11月27日
	 * @param base64
	 * @return
	 * @throws IOException
	 */
	public static String base64dec(String base64) throws IOException{
		return new String(new BASE64Decoder().decodeBuffer(base64));
	}
}
