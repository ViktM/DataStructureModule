package config;

import io.dropwizard.Configuration;

public class AppConfig extends Configuration {
    private String libraryPath;
    private String templateAuthor;
    private String defaultAuthor;

    public String getLibraryPath() {
        return libraryPath;
    }

    public String getTemplateAuthor() {
        return templateAuthor;
    }

    public String getDefaultAuthor() {
        return defaultAuthor;
    }

    public void setLibraryPath(String libraryPath) {
        this.libraryPath = libraryPath;
    }

    public void setTemplateAuthor(String templateAuthor) {
        this.templateAuthor = templateAuthor;
    }

    public void setDefaultAuthor(String defaultAuthor) {
        this.defaultAuthor = defaultAuthor;
    }
}
