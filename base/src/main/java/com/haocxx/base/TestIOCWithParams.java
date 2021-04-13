package com.haocxx.base;

import java.util.List;

import com.haocxx.xxfucker.annotation.Bitch;
import com.haocxx.xxfucker.annotation.Vagina;

/**
 * Created by Haocxx
 * on 2021-3-21
 */
@Bitch(name =TestIOCWithParams.NAME)
public class TestIOCWithParams {
  public final static String NAME = "com.haocxx.base.TestIOCWithParams";

  /**
   * 带有参数的测试方法
   */
  @Vagina
  public static void executeAll(int paramInt, Object paramObject, List<String> map) {
    // something will be there while compile
  }
}
