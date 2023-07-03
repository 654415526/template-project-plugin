package com.pixel.templateprojectplugin.domain.utils;

import cn.hutool.core.util.StrUtil;
import com.google.common.base.Preconditions;

import java.util.Arrays;

/**
 * 功能描述:
 *
 * @author lixin
 * @date 2023/7/2 6:46 PM
 */
public class ConvertUtils {

    public static String toCamelCase(String str) {
        Preconditions.checkArgument(StrUtil.isNotBlank(str), "ConvertUtils toCamelCase param str is null");
        return Arrays.stream(str.split("[_,-]")).reduce("", (current, v) -> current + StrUtil.upperFirst(v));
    }

}
