package io.github.mat3e;

import org.slf4j.LoggerFactory;

import java.lang.module.Configuration;
import org.eclipse.jetty.webapp.JettyWebXmlConfiguration;


public class App {
    public static void main(String[] args) throws Exception {
        var webapp = new WebContext();
        webapp.setResourceBase("src/main/webapp");
        webapp.setContextPath("/");
        webapp.setConfigurations(new Configuration[] {
            new AnnotationConfiguration(),
                    new WebInfConfiguration(),
                    new WebXmlConfiguration(),
                    new MetaInfConfiguration(),
                    new FragmentConfiguration(),
                    new EnvConfiguration(),
                    new PlusConfiguration(),
                    new JettyWebXmlConfuguration()
        })
        };
    }
}
