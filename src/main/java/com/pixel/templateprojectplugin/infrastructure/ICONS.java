package com.pixel.templateprojectplugin.infrastructure;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

/**
 * 功能描述:
 *
 * @author lixin
 */
public class ICONS {

    private static Icon load(String path) {
        return IconLoader.getIcon(path, ICONS.class);
    }

    public static final Icon PIXEL = load("/image/pixel.png");

}
