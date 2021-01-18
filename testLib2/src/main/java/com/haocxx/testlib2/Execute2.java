package com.haocxx.testlib2;

import android.util.Log;

import com.haocxx.base.TestIOC;
import com.haocxx.xxfucker.annotation.Fucker;
import com.haocxx.xxfucker.annotation.Semen;

/**
 * Created by Haocxx
 * on 2021-1-18
 */
@Fucker
public class Execute2 {
  private final static String TAG = "Execute2";

  @Semen(bitchName = TestIOC.NAME)
  public static void doSomething() {
    Log.d(TAG, "it works.");
  }
}
