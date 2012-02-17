/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3:src/main/java/web/listener/StartupListener.p.vm.java
 */
package com.mgt.mycity.web.listener;

import java.util.Locale;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

/**
 * Enforce UTF-8 file.encoding uppon startup.<br>
 * Please add in web.xml its definition to enable it.
 *
 * <pre>
 *  &lt;listener&gt;
 *      &lt;listener-class&gt;com.mgt.mycity.web.listener.StartupListener&lt;/listener-class&gt;
 *  &lt;/listener&gt;
 * </pre>
 *
 */
public class StartupListener implements ServletContextListener {

    private static final Logger log = Logger.getLogger(StartupListener.class);

    /**
     * Called when the servlet container is starting up the application
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        if (log.isInfoEnabled()) {
            log.info("Servlet Context initialized...");
        }

        Locale.setDefault(Locale.ENGLISH);
    }

    /**
     * Called when the servlet container is stopping up the application
     */
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        if (log.isInfoEnabled()) {
            log.info("Servlet Context destroyed...");
        }
    }
}
