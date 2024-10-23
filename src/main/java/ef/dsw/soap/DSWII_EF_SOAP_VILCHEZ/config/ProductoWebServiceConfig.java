package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

public class ProductoWebServiceConfig {

    @Bean(name = "productos")
    public DefaultWsdl11Definition productoWsdl11Definition(XsdSchema productoEsquema){
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ProductoPort");
        wsdl11Definition.setLocationUri("/ws/productos");
        wsdl11Definition.setTargetNamespace("http://www.ef.dsw.soap/ws/objects");
        wsdl11Definition.setSchema(productoEsquema);
        return wsdl11Definition;
    }
    @Bean
    public XsdSchema productoEsquema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/producto.xsd"));
    }
}
