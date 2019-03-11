package jag.yaml.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import jag.yaml.YamlHelper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class JacksonBasedYamlHelper implements YamlHelper {

    private final ObjectMapper mapper;

    public static YamlHelper instance() {
        return new JacksonBasedYamlHelper(new ObjectMapper(new YAMLFactory()));
    }

    public String toYaml(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize object as yaml:%n" + o, e);
        }
    }

    public <Type> Type fromYaml(String document, Class<Type> klazz) {
        try {
            return mapper.readValue(document, klazz);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Failed while attempting to create class: %s from string: %n%s", klazz, document), e);
        }
    }
}
