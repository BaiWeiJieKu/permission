package com.mmall.util;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mmall.exception.ParamException;
import org.apache.commons.collections.MapUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/**
 * 数据校验（实体类，基于注解）
 * @author Administrator
 *
 */
public class BeanValidator {
	//全局校验工厂
    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    //校验方法，单个类
    public static <T> Map<String, String> validate(T t, Class... groups) {
        Validator validator = validatorFactory.getValidator();
        //获取校验结果
        Set validateResult = validator.validate(t, groups);
        if (validateResult.isEmpty()) {
            return Collections.emptyMap();//没有错误信息返回空map
        } else {
            LinkedHashMap errors = Maps.newLinkedHashMap();
            Iterator iterator = validateResult.iterator();
            while (iterator.hasNext()) {
                ConstraintViolation violation = (ConstraintViolation)iterator.next();
                //封装有问题的字段和错误信息
                errors.put(violation.getPropertyPath().toString(), violation.getMessage());
            }
            return errors;
        }
    }
    //校验集合
    public static Map<String, String> validateList(Collection<?> collection) {
    	//判断集合是否为空
        Preconditions.checkNotNull(collection);
        //迭代器
        Iterator iterator = collection.iterator();
        Map errors;

        do {
            if (!iterator.hasNext()) {
                return Collections.emptyMap();//没有值，返回空集合
            }
            Object object = iterator.next();//否则获取当前数据
            errors = validate(object, new Class[0]);//调用校验单个方法
        } while (errors.isEmpty());

        return errors;
    }
    //校验任何对象
    public static Map<String, String> validateObject(Object first, Object... objects) {
        if (objects != null && objects.length > 0) {
            return validateList(Lists.asList(first, objects));
        } else {
            return validate(first, new Class[0]);
        }
    }
    /**
     * 只判断是否有异常
     * @param param
     * @throws ParamException，抛出自定义的参数异常com.mmall.exception.ParamException
     */
    public static void check(Object param) throws ParamException {
        Map<String, String> map = BeanValidator.validateObject(param);
        if (MapUtils.isNotEmpty(map)) {
            throw new ParamException(map.toString());
        }
    }
}
