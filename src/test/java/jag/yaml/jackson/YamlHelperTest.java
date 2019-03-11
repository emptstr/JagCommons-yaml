package jag.yaml.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import jag.yaml.YamlHelper;
import org.junit.jupiter.api.Test;

class YamlHelperTest {

    @Test
    void shouldSerializeDeserialize() {
        YamlHelper yamlHelper = JacksonBasedYamlHelper.instance();
        Object data = createTestData();
        String yaml = yamlHelper.toYaml(data);
        assertEquals(data, yamlHelper.fromYaml(yaml, Object.class));
    }

    private Map<String, Object> createTestData() {
        Map<String, Object> data = new HashMap<>();
        data.put("Integers", Arrays.asList(1, 2, 3, 4));
        data.put("Strings", Arrays.asList("Strings1", "Strings2", "Strings3"));
        return data;
    }
}