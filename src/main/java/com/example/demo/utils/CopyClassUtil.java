package com.example.demo.utils;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CopyClassUtil {
    /**
     * 单个实体之间的转换
     *
     * @param obj
     * @param result
     * @param <T>
     * @return
     */
    public static <T> T copyClass(Object obj, Class<T> result) {
        ModelMapper modelMapper = getModelMapper();
        T dto = modelMapper.map(obj, result);
        return dto;
    }

    /**
     * 实体列表之间的转换
     *
     * @param obj
     * @param result
     * @param <T>
     * @param <S>
     * @return
     */
    public static <T, S> List<T> copyClassList(List<S> obj, Class<T> result) {
        List<T> list = new ArrayList<>();
        ModelMapper modelMapper = getModelMapper();
        for (S s : obj) {
            T dto = modelMapper.map(s, result);
            list.add(dto);
        }
        return list;
    }

//    /**
//     * 实体列表Page之间的转换
//     *
//     * @param obj
//     * @param result
//     * @param <T>
//     * @param <S>
//     * @return
//     */
//    public static <T, S> Page<T> copyClassPage(Page<S> obj, Class<T> result) {
//        Page<T> page = new Page<>();
//        ModelMapper modelMapper = getModelMapper();
//        for (S s : obj) {
//            T dto = modelMapper.map(s, result);
//            page.add(dto);
//        }
//        page.setTotal(obj.getTotal());
//        return page;
//    }

    /**
     * 实体列表转换
     *
     * @param sources
     * @param type    = new TypeToken<List<T>>(){}.getType()
     * @param <S>
     * @param <T>
     * @return
     */
    public static <S, T> List<T> copyList(List<S> sources, Type type) {
        ModelMapper modelMapper = getModelMapper();
        List<T> list = modelMapper.map(sources, type);
        return list;
    }

    /**
     * 实体转换
     *
     * @param source
     * @param target
     * @param <S>
     * @param <T>
     */
    public static <S, T> void copyClass(S source, T target) {
        ModelMapper modelMapper = getModelMapper();
        modelMapper.map(source, target);
    }


    /**
     * 获取ModelMapper配置
     *
     * @return
     */
    private static ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        //设置候选属性
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        // 设置匹配策略为严格（默认为标准）
        modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        //开启字段匹配
        modelMapper.getConfiguration().setFieldMatchingEnabled(true);
        //忽略歧义（如果出现歧义跳过）
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper;
    }

}
