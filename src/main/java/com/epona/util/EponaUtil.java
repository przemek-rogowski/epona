package com.epona.util;


import java.io.Closeable;
import java.io.IOException;

public class EponaUtil {

  public static void closeSilently(Closeable closeable) {
    if (closeable != null) {
      try {
        closeable.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
