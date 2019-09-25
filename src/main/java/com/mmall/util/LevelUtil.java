package com.mmall.util;

import org.apache.commons.lang3.StringUtils;
/**
 * 部门层级工具类
 * @author Administrator
 *
 */
public class LevelUtil {
	//分隔符
    public final static String SEPARATOR = ".";

    public final static String ROOT = "0";

    // 0
    // 0.1
    // 0.1.2
    // 0.1.3
    // 0.4
    
    
    /**计算规则
     * @param parentLevel
     * @param parentId
     * @return
     */
    public static String calculateLevel(String parentLevel, int parentId) {
        if (StringUtils.isBlank(parentLevel)) {
            return ROOT;//如果是空，返回首层
        } else {
            return StringUtils.join(parentLevel, SEPARATOR, parentId);//连接
        }
    }
}
