package com.github.swagger.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.NestedConfigurationProperty;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;

import java.util.List;

/**
 * @author rensishu
 * @version 1.0.0
 * @date 2020/4/29
 */
public class ApiInfoProperties {
    public static final ApiInfoProperties DEFAULT = new ApiInfoProperties();

    private String version;
    private String title;
    private String description;
    private String termsOfServiceUrl;
    private String license;
    private String licenseUrl;
    @NestedConfigurationProperty
    private ContactProperties contact;
    private List<VendorExtension> vendorExtensions;

    public ApiInfoProperties() {
        this.version = ApiInfo.DEFAULT.getVersion();
        this.title = ApiInfo.DEFAULT.getTitle();
        this.description = ApiInfo.DEFAULT.getDescription();
        this.termsOfServiceUrl = ApiInfo.DEFAULT.getTermsOfServiceUrl();
        this.license = ApiInfo.DEFAULT.getLicense();
        this.licenseUrl = ApiInfo.DEFAULT.getLicenseUrl();
        this.contact = ContactProperties.DEFAULT_CONTACT;
        this.vendorExtensions = ApiInfo.DEFAULT.getVendorExtensions();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTermsOfServiceUrl() {
        return termsOfServiceUrl;
    }

    public void setTermsOfServiceUrl(String termsOfServiceUrl) {
        this.termsOfServiceUrl = termsOfServiceUrl;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicenseUrl() {
        return licenseUrl;
    }

    public void setLicenseUrl(String licenseUrl) {
        this.licenseUrl = licenseUrl;
    }

    public ContactProperties getContact() {
        return contact;
    }

    public void setContact(ContactProperties contact) {
        this.contact = contact;
    }

    public List<VendorExtension> getVendorExtensions() {
        return vendorExtensions;
    }

    public void setVendorExtensions(List<VendorExtension> vendorExtensions) {
        this.vendorExtensions = vendorExtensions;
    }
}
