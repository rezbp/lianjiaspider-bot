package com.pyf.common;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesUtil {

    /**
     * 加密
     * @param content 明文
     * @param key 秘钥
     */
    public static String encry(String content, String key) throws Exception {
        String IV = key;
        if (key.length() > 16) {
            // IV为商户MD5密钥后16位
            IV = key.substring(key.length() - 16);
            // RES的KEY 为商户MD5密钥的前16位
            key = key.substring(0, 16);
        }
        return encryptData(content, key, IV);
    }
    /**
     * 解密
     * @param content 密文
     * @param key 秘钥
     */
    public static String desEncry(String content, String key) throws Exception {
        String IV = key;
        if (key.length() > 16) {
            IV = key.substring(key.length() - 16);
            key = key.substring(0, 16);
        }
        return decryptData(content, key, IV);
    }

    /**
     * aes 加密
     * @param data 明文
     * @param key 秘钥
     * @param IV 初始化向量
     * @return
     */
    private static String encryptData(String data, String key, String IV) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] dataBytes = data.getBytes("UTF-8");
            int plaintextLength = dataBytes.length;
            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);
            return bytesToHexString(encrypted);
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * aes 解密
     * @param data 密文
     * @param key 秘钥
     * @param IV 初始化向量
     */
    private static String decryptData(String data, String key, String IV) throws Exception {
        try {
            byte[] encrypted = hexStringToByte(data);
            //byte[] encrypted = data.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keyspec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);
            byte[] original = cipher.doFinal(encrypted);
            return new String(original, "UTF-8");
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * byte数组转换成十六进制输出
     * @param bArr 数组
     * @return 解密后的string
     * @throws Exception
     */
    public static String bytesToHexString(byte[] bArr) {
        StringBuffer sb = new StringBuffer(bArr.length);
        String sTmp;
        for (int i = 0; i < bArr.length; i++) {
            sTmp = Integer.toHexString(0xFF & bArr[i]);
            if (sTmp.length() < 2)
                sb.append(0);
            sb.append(sTmp.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 把16进制字符串转换成字节数组
     * @param hex
     * @return byte[]
     */
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }
    /**
     *
     * @param c
     * @return byte
     */
    private static int toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

}
