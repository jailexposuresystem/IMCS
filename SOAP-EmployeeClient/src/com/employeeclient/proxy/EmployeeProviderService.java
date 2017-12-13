package com.employeeclient.proxy;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2017-12-12T21:26:35.980-06:00
 * Generated source version: 3.2.1
 * 
 */
@WebServiceClient(name = "EmployeeProviderService", 
                  wsdlLocation = "http://localhost:9090/SOAP-webservice/employee?wsdl",
                  targetNamespace = "http://service.employeeprovider.com/") 
public class EmployeeProviderService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.employeeprovider.com/", "EmployeeProviderService");
    public final static QName EmployeeProviderPort = new QName("http://service.employeeprovider.com/", "EmployeeProviderPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:9090/SOAP-webservice/employee?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(EmployeeProviderService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:9090/SOAP-webservice/employee?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public EmployeeProviderService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EmployeeProviderService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeeProviderService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public EmployeeProviderService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public EmployeeProviderService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public EmployeeProviderService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns EmployeeProvider
     */
    @WebEndpoint(name = "EmployeeProviderPort")
    public EmployeeProvider getEmployeeProviderPort() {
        return super.getPort(EmployeeProviderPort, EmployeeProvider.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmployeeProvider
     */
    @WebEndpoint(name = "EmployeeProviderPort")
    public EmployeeProvider getEmployeeProviderPort(WebServiceFeature... features) {
        return super.getPort(EmployeeProviderPort, EmployeeProvider.class, features);
    }

}