package com.anhnbt.blog.util;

import lombok.SneakyThrows;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.LocaleResolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotNull;


@Component
public class WebUtils {
    private static MessageSource messageSource;
    private static LocaleResolver localeResolver;

    public WebUtils(final MessageSource messageSource, final LocaleResolver localeResolver) {
        WebUtils.messageSource = messageSource;
        WebUtils.localeResolver = localeResolver;
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public static String getMessage(final String code, final Object... args) {
        return messageSource.getMessage(code, args, code, localeResolver.resolveLocale(getRequest()));
    }

    @SneakyThrows
    public static boolean isRequiredField(final Object dto, final String fieldName) {
        return dto.getClass().getDeclaredField(fieldName).getAnnotation(NotNull.class) != null;
    }

}
