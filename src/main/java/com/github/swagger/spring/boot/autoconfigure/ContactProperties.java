package com.github.swagger.spring.boot.autoconfigure;

import springfox.documentation.service.ApiInfo;

/**
 * @author rensishu
 * @version 1.0.0
 * @date 2020/4/29
 */
public class ContactProperties {
    public static final ContactProperties DEFAULT_CONTACT = new ContactProperties();

    private String name;
    private String url;
    private String email;

    public ContactProperties() {
        this.name = ApiInfo.DEFAULT_CONTACT.getName();
        this.url = ApiInfo.DEFAULT_CONTACT.getUrl();
        this.email = ApiInfo.DEFAULT_CONTACT.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
