package com.haocxx.xxfucker.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * She is a bitch, fucked by many fuckers.
 * Used to sign a vagina method.
 *
 * Created by Haocxx
 * on 2021-1-15
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Bitch {

  /**
   * @return Tell me what`s your name, bitch. I will fuck you.
   */
  String name();
}
