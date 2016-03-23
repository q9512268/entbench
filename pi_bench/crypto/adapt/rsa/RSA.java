package crypto.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import crypto.Util;

public class RSA@mode<?->X> {
  attributor {
    if (ENT_Util.Battery.percentRemaining() >= 0.75) {
      return @mode<high>;
    } else if (ENT_Util.Battery.percentRemaining() >= 0.50) {
      return @mode<mid>;
    } else {
      return @mode<low>;
    }
  }

  mcase<int> keySize = mcase<int> { low:768; mid:1024; high:1280; };

  PublicKey rsaPub;
  PrivateKey rsaPriv;

  public void init() {
    try {
      KeyPairGenerator rsaKeyPairGen = KeyPairGenerator.getInstance("RSA");
      // 512, 768 and 1024 are commonly used
      rsaKeyPairGen.initialize(keySize);
              
      KeyPair rsaKeyPair = rsaKeyPairGen.generateKeyPair();
              
      rsaPub = rsaKeyPair.getPublic();
      rsaPriv = rsaKeyPair.getPrivate();
    } catch (Exception e) {
      System.err.println("Caught " + e);
    }
  }
    
  public byte [] encrypt(byte[] indata, String algorithm) {
    try {
      Cipher c = Cipher.getInstance(algorithm);
      byte[] result = indata;
      
      c.init(Cipher.ENCRYPT_MODE, rsaPub);
      result = c.doFinal(result);
      
      return result;
    } catch (Exception e) {
      throw new RuntimeException("Exception in encrypt for " + algorithm + ".", e);
    }
  }
    
  public byte[] decrypt(byte[] indata, String algorithm) {
    try {
      Cipher c = Cipher.getInstance(algorithm);
      
      byte[] result = indata;
      
      c.init(Cipher.DECRYPT_MODE, rsaPriv);
      result = c.doFinal(result);
      
      return result;
    } catch (Exception e) {
      throw new RuntimeException("Exception in decrypt for " + algorithm + ".", e);
    }
  }
  
  public void runSingleEncryptDecrypt(String algorithm, String inputFile) {
    byte [] indata = Util.getTestData(inputFile);
    System.out.println("Algorithm=" + algorithm + " indata length=" + indata.length);
    byte [] cipher = encrypt(indata, algorithm);
    byte [] plain = decrypt(cipher, algorithm);
    boolean match = Util.check(indata, plain);
    System.out.println(algorithm + ":" + " plaincheck=" + Util.checkSum(plain) + (match ? " PASS" : " FAIL"));
  }
  
  public void runMultiEncryptDecrypt(String algorithm, String inputFile) {
    int blockSize = 64;
    byte [] fullIndata = Util.getTestData(inputFile);
    byte [] indata = new byte[blockSize];
    int pass = 0;
    int fail = 0;
    int check = 0;
    System.out.println("Algorithm=" + algorithm + " indata length=" + fullIndata.length);
    for (int i = 0; i + blockSize < fullIndata.length; i+= blockSize) {
      System.arraycopy(fullIndata, i, indata, 0, blockSize);
      byte [] cipher = encrypt(indata, algorithm);
      byte [] plain = decrypt(cipher, algorithm);
      if (Util.check(indata, plain)) {
        pass++;
        check += Util.checkSum(plain);
      } else {
        fail++;
      }
    }
    System.out.println(algorithm + ":" + " checksum=" + check + " pass=" + pass + " fail=" + fail);
  }
}
