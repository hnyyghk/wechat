package com._5icodes.wechat.mapper;

import com._5icodes.wechat.domain.notify.message.TextMessage;

import java.util.HashMap;
import java.util.Map;

public class MapToBeanMapperDecorator implements MapToBeanMapper {
    private final MapToBeanMapper mapToBeanMapper;

    public MapToBeanMapperDecorator(MapToBeanMapper mapToBeanMapper) {
        this.mapToBeanMapper = mapToBeanMapper;
    }

    @Override
    public TextMessage mapToBean(Map<String, String> map) {
        if (map == null) {
            return null;
        } else {
            Map<String, String> test = new HashMap<>();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                // 首字母小写
                test.put(Character.toLowerCase(key.charAt(0)) + key.substring(1), value);
            }
            return mapToBeanMapper.mapToBean(test);
        }
    }
}