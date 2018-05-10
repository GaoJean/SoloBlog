package com.solo.common.verify;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(value = { java.lang.annotation.ElementType.METHOD })
@Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
public @interface Verification {
    /**
     * token 验证
     */
	public boolean token() default true;
	
}

