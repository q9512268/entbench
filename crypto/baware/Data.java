package crypto;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import io.Context;
import io.FileCache;

public class Data@mode<?->X> {
  attributor {
    System.out.format("Size: %d\n", this.length);
    if (this.length <= 1024) {
      return @mode<low>;
    } else if (this.length <= 65536) {
      return @mode<mid>;
    } else {
      return @mode<high>;
    }
  }

  public byte[] stream;
  private int length;

  public Data(String name) {
    try {
      length = Context.fileCache.getLength(name);
      length -= length % 16; // align length to avoid padding indata...
      stream = new byte[length];

      ByteArrayInputStream bais = Context.fileCache.getStream(name);
      
      int counter = 0;
      int bytes_read = 0;
      do {
          bytes_read = bais.read(stream, counter, 16);
          counter += bytes_read;
      } while (counter + 16 <= length);
    } catch (IOException ioe) {
      throw new RuntimeException("Error getting input stream for file " + name, ioe);
    }
  }
}

