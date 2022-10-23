package com.zrxxjd.springboot.utils;

import java.util.Objects;

public class StringUtils {
    /**
     * 判断字符串是否有效(有效: 非null,非空字符串)
     */
    public static boolean isValid(String string) {
        if (Objects.isNull(string)) return false;
        return !Objects.equals("", string.trim());
    }

    /**
     * 判断字符串是否无效
     */
    public static boolean isInvalid(String string) {
        return !isValid(string);
    }
}
