package com.anhnbt.blog.common;

public class StringCommon {
    public static String stripHtmlTags(String html) {
        return html.replaceAll("<.*?>", "");
    }
}
