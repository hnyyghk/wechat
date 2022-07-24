package com._5icodes.wechat.spi;

import org.mapstruct.ap.spi.DefaultAccessorNamingStrategy;

import javax.lang.model.element.ExecutableElement;
import java.util.regex.Pattern;

/**
 * DefaultAccessorNamingStrategy返回的参数名首字母小写导致获取不到map中数据，需利用mapstruct的spi接口自定义实现，文档参考：<a href="https://mapstruct.org/documentation/stable/reference/html/#customizing-mappers-using-decorators">...</a>
 * 这种处理方式执行效率最高，缺点是在编译时需要另外引入自定义的annotationProcessor，还有另外两种处理方式，可以参考代码中的注释，但也都有各自的缺点
 * 1、使用@DecoratedWith注解传入重新构造的首字母小写map，会导致执行效率降低与内存耗费增加，文档参考：<a href="https://mapstruct.org/documentation/stable/reference/html/#customizing-mappers-using-decorators">...</a>
 * 2、使用@BeforeMapping注解将原map中的key替换为首字母小写，会导致执行效率降低与原map被修改，文档参考：<a href="https://mapstruct.org/documentation/stable/reference/html/#customizing-mappings-with-before-and-after">...</a>
 */
public class CustomAccessorNamingStrategy extends DefaultAccessorNamingStrategy {
    private static final Pattern WECHAT_NOTIFY_PACKAGE = Pattern.compile("^com._5icodes.wechat.domain.notify?\\..*");

    @Override
    public String getPropertyName(ExecutableElement method) {
        if (WECHAT_NOTIFY_PACKAGE.matcher(method.getEnclosingElement().asType().toString()).matches()) {
            String propertyName = super.getPropertyName(method);
            // 首字母大写
            return Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
        }
        return super.getPropertyName(method);
    }
}