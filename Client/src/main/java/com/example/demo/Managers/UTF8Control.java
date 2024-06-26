package com.example.demo.Managers;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class UTF8Control extends ResourceBundle.Control {
    @Override
    public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload)
            throws IllegalAccessException, InstantiationException, IOException {
        String bundleName = toBundleName(baseName, locale);
        String resourceName = toResourceName(bundleName, "properties");
        InputStream stream = loader.getResourceAsStream(resourceName);
        if (stream != null) {
            try (InputStreamReader reader = new InputStreamReader(stream, "UTF-8")) {
                return new PropertyResourceBundle(reader);
            }
        }
        return super.newBundle(baseName, locale, format, loader, reload);
    }
}