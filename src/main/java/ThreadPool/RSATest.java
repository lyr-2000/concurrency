package ThreadPool;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSATest {
    /**
     * 加解密时所需的密码，内部使用可以直接写死，外部调用动态传输可以直接在形参中定义
     */
    private static final String password ="gjh%^&(&  {}77";

    /**
     * 使用RSA对字符串进行私钥加密
     * @param str
     * @return
     */
    public static String jdkRASEncode(String str){
        try {
            //初始化密钥
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512,new SecureRandom(password.getBytes()));
            KeyPair keyPair =keyPairGenerator.generateKeyPair();
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();

            //私钥加密，公钥解密,私钥加密部分
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE,privateKey);
            byte [] bytes = cipher.doFinal(str.getBytes());
            return Base64.encode(bytes);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 使用RSA进行公钥解密
     * @param str
     * @return
     */
    public static String jdkRASDecode(String str){
        try {
            //初始化密钥
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(512,new SecureRandom(password.getBytes()));
            KeyPair keyPair =keyPairGenerator.generateKeyPair();
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();

            //私钥加密，公钥解密,公钥解密部分
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE,publicKey);
            byte [] byteContent = Base64.decode(str);
            byte [] bytes = cipher.doFinal(byteContent);
            return new String(bytes);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String string = "welcome to first RSA";
        String s = jdkRASEncode(string);
        System.out.println(s);
        System.out.println(jdkRASDecode(s));
    }
}
