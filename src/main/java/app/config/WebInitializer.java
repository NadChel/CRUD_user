package app.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
// *************************************** Один вариант ***********************************************
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{Config.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
// *************************************** Ещё вариант ***********************************************
//public class WebInitializer implements WebApplicationInitializer {
    //    @Override
//    public void onStartup(ServletContext servletContext) {
//
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//
//        context.setConfigLocation("app/config/Config.java");
////        context.register(Config.class);
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
