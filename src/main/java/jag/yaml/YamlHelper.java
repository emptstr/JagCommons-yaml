package jag.yaml;

public interface YamlHelper {
    String toYaml(Object o);

    <Type> Type fromYaml(String document, Class<Type> klazz);
}
