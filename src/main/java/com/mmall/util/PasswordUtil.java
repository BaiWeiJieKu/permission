package com.mmall.util;

import com.mmall.model.SysUser;

import java.util.Date;
import java.util.Random;
/**
 * 密码处理工具类
 * @author Administrator
 *
 */
public class PasswordUtil {

    public final static String[] word = {
            "a", "b", "c", "d", "e", "f", "g",
            "h", "j", "k", "m", "n",
            "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G",
            "H", "J", "K", "M", "N",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"
    };

    public final static String[] num = {
            "2", "3", "4", "5", "6", "7", "8", "9"
    };
    /**
     * 随机生成密码
     * @return
     */
    public static String randomPassword() {
        StringBuffer stringBuffer = new StringBuffer();
        //根据时间戳生成随机规则
        Random random = new Random(new Date().getTime());
        boolean flag = false;
        int length = random.nextInt(3) + 8;//密码长度在8到10字符之间
        for (int i = 0; i < length; i++) {
            if (flag) {
                stringBuffer.append(num[random.nextInt(num.length)]);
            } else {
                stringBuffer.append(word[random.nextInt(word.length)]);
            }
            flag = !flag;
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(randomPassword());
        Thread.sleep(100);
        System.out.println(randomPassword());
        Thread.sleep(100);
        System.out.println(randomPassword());
    }
}
