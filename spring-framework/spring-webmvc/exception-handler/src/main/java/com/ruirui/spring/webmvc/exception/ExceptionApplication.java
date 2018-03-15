package com.ruirui.spring.webmvc.exception;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;


public class ExceptionApplication {

    public static void main(String[] args) throws Exception {
        Server server = new Server(9000);

        WebAppContext webapp = new WebAppContext();
        webapp.setContextPath("/");
        File warFile = new File("src/main/webapp");
        webapp.setWar(warFile.getAbsolutePath());

        server.setHandler(webapp);

        server.start();

        server.setStopAtShutdown(true);
        server.join();
    }
}
