//package app.config;
//
//import jakarta.servlet.ServletContext;
//import jakarta.servlet.ServletRegistration;
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//public class WebInitializer implements WebApplicationInitializer {
//
//    public void onStartup(ServletContext servletContext) {
//
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//
////        context.setConfigLocation("app.config/Config.java");
//        context.register(Config.class);
//
//        // Creating a dispatcher servlet object
//        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
//
//        // Registering Dispatcher Servlet with Servlet
//        // Context
//        ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
//
//        // Setting load on startup
//        myCustomDispatcherServlet.setLoadOnStartup(1);
//
//        // Adding mapping url
//        myCustomDispatcherServlet.addMapping("/");
//    }
//}
