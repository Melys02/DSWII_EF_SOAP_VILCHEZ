package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

public class ClienteWebServiceConfig {

    @Bean(name = "clientes")
    public DefaultWsdl11Definition clienteWsdl11Definition(XsdSchema clienteEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ClientesPort");
        wsdl11Definition.setLocationUri("/ws/clientes");
        wsdl11Definition.setTargetNamespace("http://www.ef.dsw.soap/ws/objects");
        wsdl11Definition.setSchema(clienteEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema clienteEsquema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/cliente.xsd"));
    }
}
