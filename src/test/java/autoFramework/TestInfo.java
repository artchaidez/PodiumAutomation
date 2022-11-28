package autoFramework;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//TODO Learn about @Retention
// TODO Learn about @Target
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface TestInfo {
    String description() default "";
    String level() default "regression";
    String categories() default "";
    String testJira() default "";
}
