/*
 * Copyright (c) 2008 Standard Performance Evaluation Corporation (SPEC)
 *               All rights reserved.
 *
 * This source code is provided as is, without any express or implied warranty.
 */

package crypto.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import crypto.Util;
import io.Context;

import jrapl.EnergyCheckUtils;

modes {low <: mid; mid <: high; };

public class Main { 
        
    public void harnessMain() {
      ENT_Util.initModeFile();
      double[] energyRuns = new double[11];

      for (int k = 0; k < 11; k++) {
        double[] before = EnergyCheckUtils.getEnergyStats();

        RSA@mode<?> rsadyn = new RSA@mode<?>();
        RSA@mode<*> rsa = snapshot rsadyn ?mode[@mode<low>,@mode<high>];
        rsa.init(); 

        rsa.runSingleEncryptDecrypt("RSA/ECB/PKCS1Padding", Util.TEST_DATA_3);
        rsa.runMultiEncryptDecrypt("RSA/ECB/PKCS1Padding", Util.TEST_DATA_5);
        // Run some more, in order to increase operation workload.
        rsa.runSingleEncryptDecrypt("RSA/ECB/PKCS1Padding", Util.TEST_DATA_3);
        rsa.runMultiEncryptDecrypt("RSA/ECB/PKCS1Padding", Util.TEST_DATA_5);
        rsa.runSingleEncryptDecrypt("RSA/ECB/PKCS1Padding", Util.TEST_DATA_3);

        double[] after = EnergyCheckUtils.getEnergyStats();
        ENT_Util.writeModeFile(String.format("ERun %d: %f %f %f\n", k, after[0]-before[0], after[1]-before[1], after[2]-before[2]));
        energyRuns[k] = after[2]-before[2];
      }

      double energyTotal = 0.0;
      for (int k = 1; k < 11; k++) {
        energyTotal += energyRuns[k];
      }
      ENT_Util.writeModeFile(String.format("Energy: %f %f %f\n", 0.0, 0.0, (energyTotal / 10.0)));
    }
    
    public static void setupBenchmark() {
      try {
        Context.fileCache.loadFile(Util.TEST_DATA_3);
        Context.fileCache.loadFile(Util.TEST_DATA_5); 
      } catch (Exception e) {
        throw new RuntimeException("Error in setup of crypto.aes." + e);
      }
    }

    public static void main(String[] args) throws Exception {
        
        // Used to create 96 bytes random data for input
        // Util.createRandomTestData(Util.TEST_DATA_3, );
        
        setupBenchmark();
        Main m = new Main();
        m.harnessMain();
    }
    
}
