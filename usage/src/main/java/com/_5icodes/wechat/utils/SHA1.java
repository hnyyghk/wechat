/**
 * 对公众平台发送给公众账号的消息加解密示例代码.
 * 
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

package com._5icodes.wechat.utils;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * SHA1 class
 *
 * 计算公众平台的消息签名接口.
 */
class SHA1 {

	/**
	 * 用SHA1算法生成安全签名
	 * @param array token 票据 timestamp 时间戳 nonce 随机字符串 encrypt 密文
	 * @return 安全签名
	 * @throws AesException 
	 */
	public static String getSHA1(String[] array) throws AesException
			  {
		try {
			StringBuilder sb = new StringBuilder();
			// 字符串排序
			Arrays.sort(array);
			for (String s : array) {
				sb.append(s);
			}
			String str = sb.toString();
			// SHA1签名生成
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuilder hexStr = new StringBuilder();
			for (byte b : digest) {
				String shaHex = Integer.toHexString(b & 0xFF);
				if (shaHex.length() < 2) {
					hexStr.append(0);
				}
				hexStr.append(shaHex);
			}
			return hexStr.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ComputeSignatureError);
		}
	}
}
