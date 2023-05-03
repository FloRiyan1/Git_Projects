package verschluesselung.service;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class VerschluesselungsServiceImpl {

	 private static final String TRANSFORMATION = "DESede/ECB/PKCS5Padding";
	 private static final String ENCRYPTION_ALGORITHM = "DESede";
	 
	 private KeyServiceImpl keyService;
	 
	 public VerschluesselungsServiceImpl(KeyServiceImpl keyService)
	 {
		 this.keyService = keyService;
	 }
	 
	 public String encrypt(String plainText, String key) throws Exception {
		 Key desKey = new SecretKeySpec(keyService.stringToByteArray(key), ENCRYPTION_ALGORITHM);
		 Cipher cipher = Cipher.getInstance(TRANSFORMATION);
		 cipher.init(Cipher.ENCRYPT_MODE, desKey);
		 return keyService.byteArrayToString(cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8)));
	 }
	 
	 public String decrypt(String encryptedText, String key) throws Exception {
		 Key desKey = new SecretKeySpec(keyService.stringToByteArray(key), ENCRYPTION_ALGORITHM);
		 Cipher cipher = Cipher.getInstance(TRANSFORMATION);
		 cipher.init(Cipher.DECRYPT_MODE, desKey);
		 byte[] decryptedBytes = cipher.doFinal(keyService.stringToByteArray(encryptedText));
		 return new String(decryptedBytes, StandardCharsets.UTF_8);
	 }	
	
}
