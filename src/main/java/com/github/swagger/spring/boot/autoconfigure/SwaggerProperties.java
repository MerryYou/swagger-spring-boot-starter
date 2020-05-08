package com.github.swagger.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Swagger配置信息
 *
 * @author rensishu
 * @version 1.0.0
 * @date 2020/4/29
 */
@ConfigurationProperties(prefix = SwaggerProperties.SWAGGER_PREFIX, ignoreInvalidFields = true)
public class SwaggerProperties {

    public static final String SWAGGER_PREFIX = "swagger";
    public static final String PATH_MAPPING = "/";

    private String pathMapping = PATH_MAPPING;

    private String basePackage;

    /**
     * swagger路径选择器,默认any
     */
    private PathSelectorOptions pathSelector = PathSelectorOptions.ANY;

    private String pathRegex;

    @NestedConfigurationProperty
    private ApiInfoProperties apiInfo = ApiInfoProperties.DEFAULT;

    public String getPathMapping() {
        return pathMapping;
    }

    public void setPathMapping(String pathMapping) {
        this.pathMapping = pathMapping;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public PathSelectorOptions getPathSelector() {
        return pathSelector;
    }

    public void setPathSelector(PathSelectorOptions pathSelector) {
        this.pathSelector = pathSelector;
    }

    public String getPathRegex() {
        return pathRegex;
    }

    public void setPathRegex(String pathRegex) {
        this.pathRegex = pathRegex;
    }

    public ApiInfoProperties getApiInfo() {
        return apiInfo;
    }

    public void setApiInfo(ApiInfoProperties apiInfo) {
        this.apiInfo = apiInfo;
    }
}
