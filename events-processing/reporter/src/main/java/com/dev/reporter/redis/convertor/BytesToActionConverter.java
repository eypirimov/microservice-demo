package com.dev.reporter.redis.convertor;

import com.dev.reporter.domains.Action;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

@Component
@ReadingConverter
public class BytesToActionConverter implements Converter<byte[], Action> {

    private final Jackson2JsonRedisSerializer<Action> serializer;

    public BytesToActionConverter() {
        serializer = new Jackson2JsonRedisSerializer<>(Action.class);
        serializer.setObjectMapper(new ObjectMapper());
    }

    @Override
    public Action convert(byte[] value) {
        if (value == null || value.length == 0)
            return null;
        return serializer.deserialize(value);
    }
}
