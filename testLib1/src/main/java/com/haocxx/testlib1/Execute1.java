package com.haocxx.testlib1;

import android.util.Log;

import com.haocxx.base.TestIOC;
import com.haocxx.xxfucker.annotation.Fucker;
import com.haocxx.xxfucker.annotation.Semen;

/**
 * Created by Haocxx
 * on 2021-1-18
 */
@Fucker
public class Execute1 {
  private final static String TAG = "Execute1";

  @Semen(bitchName = TestIOC.NAME)
  public static void doSomething() {
    Log.d(TAG, "it works.");
  }
}
