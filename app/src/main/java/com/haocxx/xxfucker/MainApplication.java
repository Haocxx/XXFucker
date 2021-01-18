package com.haocxx.xxfucker;

import android.app.Application;

import com.haocxx.base.TestIOC;

/**
 * Created by Haocxx
 * on 2021-1-18
 */
public class MainApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    TestIOC.executeAll();
  }
}
