package com.cuubez.visualizer.annotation;

import java.lang.annotation.*;

@Documented
@Retention(value= RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE,ElementType.PARAMETER})
public @interface ParameterDetail {

    String value();
}
