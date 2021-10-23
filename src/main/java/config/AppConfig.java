package config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.constraints.NotEmpty;

public class AppConfig extends Configuration {
    @NotEmpty
    private String libraryPath;
    @NotEmpty
    private String defaultAuthor;

    @JsonProperty
    public String getLibraryPath() {
        return libraryPath;
    }

    @JsonProperty
    public String getDefaultAuthor() {
        return defaultAuthor;
    }

    @JsonProperty
    public void setLibraryPath(String libraryPath) {
        this.libraryPath = libraryPath;
    }

    @JsonProperty
    public void setDefaultAuthor(String defaultAuthor) {
        this.defaultAuthor = defaultAuthor;
    }
}
