package com.example.utils;

import java.io.FileInputStream;
import java.security.PrivateKey;
import java.security.PublicKey;

public class SecurityUtils {
    /**
     * 解密
     * @param cipherText 密文
     * @return 返回解密后的字符串
     * @throws Exception
     */
    public static String decrypt(String cipherText) throws Exception{
        // 从文件中得到私钥
//        FileInputStream inPrivate = new FileInputStream(
//                SecurityUtils.class.getClassLoader().getResource("").getPath() + "/pkcs8_private_key.pem");
        String inPrivate = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALsCtwJy6uYYdd6M\n" +
                "EGOrydeciG/CA1gKMSMbAwX+bm5pce1KASAdxCiam+/rlzQI2YoBcclxzzxeDFNk\n" +
                "cJZfYAToSHc/H3X+V9PswzxYZMS8vhPjVtVsury5pJpGMvZRUgrKXldn2yvmJUpw\n" +
                "VWBP6hyXtlc+Tm1WDQxYfRRpGL5JAgMBAAECgYEAl2PlP2hEXK0kjlqY0fc52P/x\n" +
                "O3e2OUlW6fJuCiYkw+E8xzmHm7Y9HBm9bwYrS4Z2hNASi19EwrvoAoJm2nSvRydX\n" +
                "NAAvKc80RD2kjUoCgU0DCe8gihe4E28wLU7KgXY7YYWyl/4mdB63ZiQKjKusLXNw\n" +
                "2Jm/2m6vDrSM+bsaTQECQQDg4u9VME1N3I8GxXuYXM/mu8rw4DIpKWLH8SY6XAyF\n" +
                "32dtAnweqKji3ic3T6hzfGkOpBq/1DAncZmnNFacr6rRAkEA1OJJZBDeSqOSjoi+\n" +
                "x1jhKSz5cfRZeYD89H3rWexHQbYO212MA0RueIZQySFuXv8Naa00XYwyoaTok2hY\n" +
                "d6ZJ+QJBAIE8KMnN7j7WhyMfDf3rKFayiNeQH4NkEy5PuOZEy7WLQwZ0LRv5VMS7\n" +
                "YdH5Zxam4kDVscGXkOy57dEW1MdKdGECQCuZRIqX4c7LfUJvwxK0ozh5m4S5FHIL\n" +
                "9sJj34WFHHravGQ03m303+MTLwxiKmaOOcMA1A6sndn5GiDGaAfpKJECQGXnixxA\n" +
                "KeNkZBSm1RPCRYVcDbaUiBN33LYqYvYFIS5+hSZYwMo1fuaWEC2gx8AKohQ9Jz3L\n" +
                "7sw9yE51xyAgudg=";
        PrivateKey privateKey = RSAUtils.loadPrivateKey(inPrivate);
        byte[] decryptByte = RSAUtils.decryptData(Base64Utils.decode(cipherText), privateKey);
        String decryptStr = new String(decryptByte,"utf-8");
        return decryptStr;
    }
    /**
     * 加密
     * @param plainTest 明文
     * @return	返回加密后的密文
     * @throws Exception
     */
    public static String encrypt(String plainTest) throws Exception{
//        FileInputStream inPublic = new FileInputStream(
//                SecurityUtils.class.getClassLoader().getResource("").getPath() + "/rsa_public_key.pem");
        String inPublic = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC7ArcCcurmGHXejBBjq8nXnIhv\n" +
                "wgNYCjEjGwMF/m5uaXHtSgEgHcQompvv65c0CNmKAXHJcc88XgxTZHCWX2AE6Eh3\n" +
                "Px91/lfT7MM8WGTEvL4T41bVbLq8uaSaRjL2UVIKyl5XZ9sr5iVKcFVgT+ocl7ZX\n" +
                "Pk5tVg0MWH0UaRi+SQIDAQAB";
        PublicKey publicKey = RSAUtils.loadPublicKey(inPublic);
        // 加密
        byte[] encryptByte = RSAUtils.encryptData(plainTest.getBytes(), publicKey);
        String afterencrypt = Base64Utils.encode(encryptByte);
        return afterencrypt;
    }


    public static void main(String[] args) throws Exception {
        String example = "HelloWorld123";
        System.out.println(example);

        String ciphertext = encrypt(example);
        System.out.println("密文:" + ciphertext);

        String plaintext = decrypt(ciphertext);
        System.out.println("明文:" + plaintext);
    }
}
