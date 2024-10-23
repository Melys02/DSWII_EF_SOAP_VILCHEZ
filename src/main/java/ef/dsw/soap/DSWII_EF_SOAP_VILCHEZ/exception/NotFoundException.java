package ef.dsw.soap.DSWII_EF_SOAP_VILCHEZ.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
        customFaultCode = "{http://www.ef.dsw.soap/ws}001")
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message){
        super(message);
    }

}