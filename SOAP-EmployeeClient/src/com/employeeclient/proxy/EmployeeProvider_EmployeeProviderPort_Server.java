
package com.employeeclient.proxy;

import javax.xml.ws.Endpoint;

/**
 * This class was generated by Apache CXF 3.2.1
 * 2017-12-12T21:26:35.960-06:00
 * Generated source version: 3.2.1
 * 
 */
 
public class EmployeeProvider_EmployeeProviderPort_Server{

    protected EmployeeProvider_EmployeeProviderPort_Server() throws java.lang.Exception {
        System.out.println("Starting Server");
        Object implementor = new EmployeeProviderPortImpl();
        String address = "http://localhost:9090/SOAP-webservice/employee";
        Endpoint.publish(address, implementor);
    }
    
    public static void main(String args[]) throws java.lang.Exception { 
        new EmployeeProvider_EmployeeProviderPort_Server();
        System.out.println("Server ready..."); 
        
        Thread.sleep(5 * 60 * 1000); 
        System.out.println("Server exiting");
        System.exit(0);
    }
}