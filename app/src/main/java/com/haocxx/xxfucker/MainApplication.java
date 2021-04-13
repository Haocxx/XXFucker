package com.haocxx.xxfucker;

import java.util.ArrayList;

import android.app.Application;

import androidx.annotation.NonNull;

import com.haocxx.base.TestIOC;
import com.haocxx.base.TestIOCWithParams;

/**
 * Created by Haocxx
 * on 2021-1-18
 */
public class MainApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    TestIOC.executeAll();
    TestIOCWithParams.executeAll(817, new PhantomObject(), new ArrayList<String>());
  }

  private static class PhantomObject {
    @NonNull
    @Override
    public String toString() {
      return "PhantomObject HashNo." + hashCode();
    }
  }
}
