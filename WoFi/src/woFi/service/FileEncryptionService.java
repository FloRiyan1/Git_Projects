package woFi.service;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class FileEncryptionService {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    public void encryptFile(File inputFile, File outputFile, String key) throws Exception {
        doCrypto(Cipher.ENCRYPT_MODE, inputFile, outputFile, key);
    }

    public void decryptFile(File inputFile, File outputFile, String key) throws Exception {
        doCrypto(Cipher.DECRYPT_MODE, inputFile, outputFile, key);
    }

    private static void doCrypto(int cipherMode, File inputFile, File outputFile, String key) throws Exception {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);
            
            // Additional steps before encryption
            if (cipherMode == Cipher.ENCRYPT_MODE) {
                // Add data to inputBytes before encryption
                String additionalData = "Additional data to be added";
                byte[] additionalDataBytes = additionalData.getBytes();
                byte[] encryptedData = cipher.doFinal(additionalDataBytes);
                inputBytes = concatArrays(inputBytes, encryptedData);
            }

            byte[] outputBytes = cipher.doFinal(inputBytes);

            // Additional steps after decryption
            if (cipherMode == Cipher.DECRYPT_MODE) {
                // Remove data from outputBytes after decryption
                int additionalDataLength = 22; // Length of the additional data
                byte[] decryptedData = new byte[outputBytes.length - additionalDataLength];
                System.arraycopy(outputBytes, 0, decryptedData, 0, decryptedData.length);
                outputBytes = decryptedData;
            }
            
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();
        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                | InvalidKeyException | BadPaddingException
                | IllegalBlockSizeException | IOException ex) {
            throw new Exception("Error encrypting/decrypting file: " + ex.getMessage(), ex);
        }
    }
    
    private static byte[] concatArrays(byte[] a, byte[] b) 
    {
        byte[] result = new byte[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
}
