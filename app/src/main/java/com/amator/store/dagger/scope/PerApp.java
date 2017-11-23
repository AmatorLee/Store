package com.amator.store.dagger.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by AmatorLee on 2017/11/23.
 * 限定App作用域
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerApp {


}
