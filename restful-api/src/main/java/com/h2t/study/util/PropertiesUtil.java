package com.h2t.study.util;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;


public class PropertiesUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(PropertyUtils.class);
    public static void copyProperties(Object dest, Object orig) {
        try {
            PropertyUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOGGER.error("properties copy throw exception, dest:{}, orig:{}, e:{}", dest, orig, e);
        }

    }
}
