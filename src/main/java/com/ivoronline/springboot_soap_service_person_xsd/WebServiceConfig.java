package com.ivoronline.springboot_soap_service_person_xsd;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

  //===============================================================================
  // WEB SERVICE ENDPOINT (URL)
  //===============================================================================
  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet  servlet = new MessageDispatcherServlet();
                              servlet.setApplicationContext(applicationContext);
                              servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<>(servlet, "/PersonWebService");
  }

}