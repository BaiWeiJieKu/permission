package com.mmall.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * 搜索权限记录参数
 * @author Administrator
 *
 */
@Getter
@Setter
@ToString
public class SearchLogParam {

    private Integer type; // LogType

    private String beforeSeg;

    private String afterSeg;

    private String operator;

    private String fromTime;//yyyy-MM-dd HH:mm:ss

    private String toTime;
}
