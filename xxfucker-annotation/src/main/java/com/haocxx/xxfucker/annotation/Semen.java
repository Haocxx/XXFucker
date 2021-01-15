package com.haocxx.xxfucker.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Fucker`s semen, will inject into the vagina method.
 * Fucker has more than one semen.
 *
 * Created by Haocxx
 * on 2021-1-15
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface Semen {
  /**
   * @return Tell me a bitch name, I will lead to to fuck her during transform.
   */
  String bitchName();
}
