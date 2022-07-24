package com._5icodes.wechat.mapper;

import com._5icodes.wechat.domain.notify.message.TextMessage;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Map;

@Mapper
//@DecoratedWith(MapToBeanMapperDecorator.class)
public interface MapToBeanMapper {
//    @BeforeMapping
//    default void toLowerCase(Map<String, String> map) {
//        if (map != null) {
//            for (String key : new ArrayList<>(map.keySet())) {
//                String value = map.remove(key);
//                // 首字母小写
//                map.put(Character.toLowerCase(key.charAt(0)) + key.substring(1), value);
//            }
//        }
//    }

    MapToBeanMapper INSTANCE = Mappers.getMapper(MapToBeanMapper.class);

    TextMessage mapToBean(Map<String, String> map);
}