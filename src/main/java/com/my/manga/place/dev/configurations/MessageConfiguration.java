package com.my.manga.place.dev.configurations;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
@Configuration
public class MessageConfiguration {
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /**
     * Se encarga de configurar un bean de validación local
     * utilizando LocalValidatorFactoryBean y vinculándolo con una
     * fuente de mensajes de validación configurada a través del método messageSource().
     * Este bean de validación se puede inyectar en otras partes de la aplicación
     * para llevar a cabo la validación de los datos ingresados en formularios
     * u otras interacciones.
     *
     * @return Retorna un objeto del tipo LocalValidatorFactoryBean
     * para registrarse en el contenedor de beans y poder utilizar las propiedades
     * que contienen mensajes en el messages.properties para así mostrarlos
     * en los errores de validación
     * @author Emanuel Sotomayor
     */
    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(this.messageSource());
        return bean;
    }

}
