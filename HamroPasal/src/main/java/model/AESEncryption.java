package model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption {
	
	private static final String ALGORITHM = "AES";
    private static final String KEY = "qwertyuiopasdfgh";
		
    
    public static String encrypt(String plainText){
    	String encryptedPassword = plainText;
    	try {
    		SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
    		Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec);
            byte[] ciphertext = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
            encryptedPassword = Base64.getEncoder().encodeToString(ciphertext); 
    	}
    	catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return encryptedPassword;
        
    }

    public static String decrypt(String ciphertext){
    	String decryptedPassword = ciphertext;
    	try {
    		SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);
    		Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, keySpec);
            byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(ciphertext));
            decryptedPassword =  new String(decryptedData, StandardCharsets.UTF_8);
    	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    	return decryptedPassword;
    	
        
    }
}