package com.haocxx.testlib2;

import java.util.List;

import android.util.Log;

import com.haocxx.base.TestIOCWithParams;
import com.haocxx.xxfucker.annotation.Fucker;
import com.haocxx.xxfucker.annotation.Semen;

/**
 * Created by Haocxx
 * on 2021-3-21
 */
@Fucker
public class ExecuteWithParams2 {
  private final static String TAG = "TestIOCWithParams2";

  @Semen(bitchName = TestIOCWithParams.NAME)
  public static void doSomething(int paramInt, Object paramObject, List<String> map) {
    Log.d(TAG, "it works." + "paramInt:" + paramInt
        + ", paramObject:" + paramObject.toString()
        + ", map:" + map.toString());
  }
}
