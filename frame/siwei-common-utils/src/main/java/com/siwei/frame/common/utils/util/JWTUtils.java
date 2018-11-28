package com.siwei.frame.common.utils.util;

import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;

/**
 * JWT工具类 RSA 公私钥加密
 * */
public class JWTUtils {
    private static RSAPrivateKey priKey;
    private static RSAPublicKey pubKey;
    private static class SingletonHolder {
        private static final JWTUtils INSTANCE = new JWTUtils();
    }
    public synchronized static JWTUtils getInstance(String privateKey, String publicKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        if (priKey == null && pubKey == null) {
            priKey = RSAUtil.getPrivateKey(privateKey);
            pubKey = RSAUtil.getPublicKey(publicKey);
        }
        return SingletonHolder.INSTANCE;
    }
    public synchronized static void reload(String privateKey, String publicKey) throws InvalidKeySpecException, NoSuchAlgorithmException {
        priKey = RSAUtil.getPrivateKey(privateKey);
        pubKey = RSAUtil.getPublicKey(publicKey);
    }

}
