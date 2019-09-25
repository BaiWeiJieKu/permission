package com.mmall.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 角色和权限关系表
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleAcl {
    private Integer id;

    private Integer roleId;//角色id

    private Integer aclId;//权限id

    private String operator;//操作者

    private Date operateTime;//最后一次更新的时间

    private String operateIp;//最后一次更新者的ip

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAclId() {
        return aclId;
    }

    public void setAclId(Integer aclId) {
        this.aclId = aclId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public String getOperateIp() {
        return operateIp;
    }

    public void setOperateIp(String operateIp) {
        this.operateIp = operateIp == null ? null : operateIp.trim();
    }
}