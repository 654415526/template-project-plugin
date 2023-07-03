package com.pixel.templateprojectplugin.domain.utils;

import cn.hutool.core.util.StrUtil;
import com.intellij.ide.RecentProjectsManager;
import com.intellij.openapi.projectRoots.ProjectJdkTable;
import com.intellij.openapi.projectRoots.Sdk;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 功能描述:
 *
 * @author lixin
 * @date 2023/6/28 3:54 PM
 */
public class IDEAUtils {

    public static String getLocationUrl() {
        RecentProjectsManager recentProjectsManager = RecentProjectsManager.getInstance();
        String lastProjectCreationLocation = recentProjectsManager.getLastProjectCreationLocation();
        if (lastProjectCreationLocation == null || lastProjectCreationLocation.length() == 0) {
            return System.getProperty("user.dir");
        }
        return lastProjectCreationLocation;
    }

    public static List<String> getJavaSDK() {
        Sdk[] allJdks = ProjectJdkTable.getInstance().getAllJdks();
        if (allJdks.length != 0) {
            return Arrays.stream(allJdks).map(v -> {
                if (v.getSdkType().getName().contains("JavaSDK")) {
                    return v.getName();
                }
                return null;
            }).filter(Objects::nonNull).collect(Collectors.toList());
        }
        return null;
    }

    public static Sdk getJavaSDK(String javaVersion) {
        Sdk[] allJdks = ProjectJdkTable.getInstance().getAllJdks();
        for (Sdk sdk : allJdks) {
            if (StrUtil.equals(javaVersion, sdk.getName())) {
                return sdk;
            }
        }
        return allJdks[0];
    }

}
