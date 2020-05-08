package com.github.swagger.spring.boot.autoconfigure;

/**
 * Swagger路径选择器选项
 * 最终具体的选择器对象可参考 {@link springfox.documentation.builders.PathSelectors}
 *
 * @author rensishu
 * @version 1.0.0
 * @date 2020/4/29
 */
public enum PathSelectorOptions {
    /**
     * Any path satisfies this condition
     */
    ANY,
    /**
     * No path satisfies this condition
     */
    NONE,
    /**
     * Predicate that evaluates the supplied regular expression
     */
    REGEX,
    /**
     * Predicate that evaluates the supplied ant pattern
     */
    ANT
}
