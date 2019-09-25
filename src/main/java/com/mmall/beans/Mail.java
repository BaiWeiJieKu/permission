package com.mmall.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;
/**
 * 需要发送的邮件信息
 * @author Administrator
 *
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mail {

	/**
	 * 主题
	 */
    private String subject;
    
    /**
     * 内容
     */
    private String message;

    /**
     * 接收者
     */
    private Set<String> receivers;
}
