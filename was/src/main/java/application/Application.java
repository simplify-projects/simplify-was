package application;

import was.apache.tomcat.catalina.Tomcat;

public class Application {

    public static void main(String[] args) {
        final Tomcat tomcat = new Tomcat();
        tomcat.boot();
    }

}
