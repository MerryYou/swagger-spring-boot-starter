package com.github.swagger.spring.boot.autoconfigure;

import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.ApiSelector;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author rensishu
 * @version 1.0.0
 * @date 2020/4/29
 */
@EnableSwagger2
@Configuration
@EnableConfigurationProperties({SwaggerProperties.class})
public class SwaggerAutoConfiguration {

    private final SwaggerProperties properties;

    public SwaggerAutoConfiguration(SwaggerProperties properties) {
        this.properties = properties;
    }

    @Bean
    @ConditionalOnMissingBean(Docket.class)
    public Docket createRestApi() {
        ApiInfoProperties apiInfoProperties = this.properties.getApiInfo();
        ContactProperties contactProperties = apiInfoProperties.getContact();
        Contact contact = new Contact(contactProperties.getName(), contactProperties.getUrl(), contactProperties.getEmail());
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title(apiInfoProperties.getTitle())
                .description(apiInfoProperties.getDescription())
                .version(apiInfoProperties.getVersion())
                .license(apiInfoProperties.getLicense())
                .licenseUrl(apiInfoProperties.getLicenseUrl())
                .contact(contact)
                .termsOfServiceUrl(apiInfoProperties.getTermsOfServiceUrl())
                .build();
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping(this.properties.getPathMapping())
                .select()
                .apis(selector(this.properties.getBasePackage()))
                .paths(pathSelector(this.properties.getPathSelector(), this.properties.getPathRegex()))
                .build().apiInfo(apiInfo);
    }

    private Predicate<RequestHandler> selector(String basePackage) {
        if (basePackage == null || basePackage.length() == 0) {
            return ApiSelector.DEFAULT.getRequestHandlerSelector();
        }
        return RequestHandlerSelectors.basePackage(basePackage);
    }

    private Predicate<String> pathSelector(PathSelectorOptions pathSelector, String pathRegex) {
        if (PathSelectorOptions.ANT.equals(pathSelector)) {
            return PathSelectors.any();
        } else if (PathSelectorOptions.NONE.equals(pathSelector)) {
            return PathSelectors.none();
        } else if (PathSelectorOptions.REGEX.equals(pathSelector)) {
            requireNonNull(pathRegex, "when you choose the path selector of regex, the pathRegex should be not null.");
            PathSelectors.regex(pathRegex);
        } else if (PathSelectorOptions.ANT.equals(pathSelector)) {
            requireNonNull(pathRegex, "when you choose the path selector of ant, the pathRegex should be not null.");
            return PathSelectors.ant(pathRegex);
        }
        return PathSelectors.any();
    }

    private <T> T requireNonNull(T obj, String message) {
        if (obj == null)
            throw new NullPointerException(message);
        return obj;
    }
}
