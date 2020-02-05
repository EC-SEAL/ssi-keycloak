/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.uaegean.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 *
 * @author nikos
 */
public class PropertiesService {

    private final Properties prop;
    private final static Logger LOG = LoggerFactory.getLogger(PropertiesService.class);

    public PropertiesService() throws IOException {
//        LOG.info("init prop service");
        this.prop = new Properties();
        try {
            InputStream input = new FileInputStream("/ssiConfig/ssi.properties");
            this.prop.load(input);
        } catch (IOException e) {
            LOG.error("file error");
            LOG.error(e.getMessage());
        }

//        LOG.info("prop loaded");
//        LOG.info("prop TEST " + this.prop.getProperty("test"));
    }

    public String getProp(String propertyName) {
//        LOG.info("prop file value ");
//        LOG.info(this.prop.getProperty(propertyName));
//        LOG.info("env ");
//        LOG.info(System.getenv(propertyName));
        return StringUtils.isEmpty(this.prop.getProperty(propertyName)) ? System.getenv(propertyName) : this.prop.getProperty(propertyName);
    }

}