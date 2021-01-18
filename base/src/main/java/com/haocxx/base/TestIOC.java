package com.haocxx.base;

import com.haocxx.xxfucker.annotation.Bitch;
import com.haocxx.xxfucker.annotation.Vagina;

/**
 * Created by Haocxx
 * on 2021-1-18
 */
@Bitch(name =TestIOC.NAME)
public class TestIOC {
  public final static String NAME = "com.haocxx.base.TestIOC";

  @Vagina
  public static void executeAll() {
    // something will be there while compile
  }
}