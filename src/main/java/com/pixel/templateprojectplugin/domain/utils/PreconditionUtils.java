package com.pixel.templateprojectplugin.domain.utils;

import com.intellij.openapi.ui.Messages;

import javax.annotation.CheckForNull;

/**
 * 功能描述:
 *
 * @author lixin
 * @date 2023/7/2 8:31 PM
 */
public class PreconditionUtils {

    public static void checkArgument(boolean expression, @CheckForNull String errorMessage) {
        if (!expression) {
            Messages.showInfoMessage(errorMessage, "Error Message");
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
