package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

public class ContactWebServiceConfig {

    @Bean(name = "contacto")
    public DefaultWsdl11Definition contactoWsdl11Definition(XsdSchema contactoEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ContactoPort");
        wsdl11Definition.setLocationUri("/ws/contactos");
        wsdl11Definition.setTargetNamespace("http://www.ef.dsw.soap/ws/objects");
        wsdl11Definition.setSchema(contactoEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema contactoEsquema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/contacto.xsd"));
    }

}
