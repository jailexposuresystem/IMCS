
package com.employeeclient.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.employeeclient.proxy package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddEmployee_QNAME = new QName("http://service.employeeprovider.com/", "addEmployee");
    private final static QName _AddEmployeeResponse_QNAME = new QName("http://service.employeeprovider.com/", "addEmployeeResponse");
    private final static QName _FindByName_QNAME = new QName("http://service.employeeprovider.com/", "findByName");
    private final static QName _FindByNameResponse_QNAME = new QName("http://service.employeeprovider.com/", "findByNameResponse");
    private final static QName _FindEmployee_QNAME = new QName("http://service.employeeprovider.com/", "findEmployee");
    private final static QName _FindEmployeeResponse_QNAME = new QName("http://service.employeeprovider.com/", "findEmployeeResponse");
    private final static QName _RemoveEmployee_QNAME = new QName("http://service.employeeprovider.com/", "removeEmployee");
    private final static QName _RemoveEmployeeResponse_QNAME = new QName("http://service.employeeprovider.com/", "removeEmployeeResponse");
    private final static QName _UpdateEmployee_QNAME = new QName("http://service.employeeprovider.com/", "updateEmployee");
    private final static QName _UpdateEmployeeResponse_QNAME = new QName("http://service.employeeprovider.com/", "updateEmployeeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.employeeclient.proxy
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddEmployee }
     * 
     */
    public AddEmployee createAddEmployee() {
        return new AddEmployee();
    }

    /**
     * Create an instance of {@link AddEmployeeResponse }
     * 
     */
    public AddEmployeeResponse createAddEmployeeResponse() {
        return new AddEmployeeResponse();
    }

    /**
     * Create an instance of {@link FindByName }
     * 
     */
    public FindByName createFindByName() {
        return new FindByName();
    }

    /**
     * Create an instance of {@link FindByNameResponse }
     * 
     */
    public FindByNameResponse createFindByNameResponse() {
        return new FindByNameResponse();
    }

    /**
     * Create an instance of {@link FindEmployee }
     * 
     */
    public FindEmployee createFindEmployee() {
        return new FindEmployee();
    }

    /**
     * Create an instance of {@link FindEmployeeResponse }
     * 
     */
    public FindEmployeeResponse createFindEmployeeResponse() {
        return new FindEmployeeResponse();
    }

    /**
     * Create an instance of {@link RemoveEmployee }
     * 
     */
    public RemoveEmployee createRemoveEmployee() {
        return new RemoveEmployee();
    }

    /**
     * Create an instance of {@link RemoveEmployeeResponse }
     * 
     */
    public RemoveEmployeeResponse createRemoveEmployeeResponse() {
        return new RemoveEmployeeResponse();
    }

    /**
     * Create an instance of {@link UpdateEmployee }
     * 
     */
    public UpdateEmployee createUpdateEmployee() {
        return new UpdateEmployee();
    }

    /**
     * Create an instance of {@link UpdateEmployeeResponse }
     * 
     */
    public UpdateEmployeeResponse createUpdateEmployeeResponse() {
        return new UpdateEmployeeResponse();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.employeeprovider.com/", name = "addEmployee")
    public JAXBElement<AddEmployee> createAddEmployee(AddEmployee value) {
        return new JAXBElement<AddEmployee>(_AddEmployee_QNAME, AddEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.employeeprovider.com/", name = "addEmployeeResponse")
    public JAXBElement<AddEmployeeResponse> createAddEmployeeResponse(AddEmployeeResponse value) {
        return new JAXBElement<AddEmployeeResponse>(_AddEmployeeResponse_QNAME, AddEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.employeeprovider.com/", name = "findByName")
    public JAXBElement<FindByName> createFindByName(FindByName value) {
        return new JAXBElement<FindByName>(_FindByName_QNAME, FindByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.employeeprovider.com/", name = "findByNameResponse")
    public JAXBElement<FindByNameResponse> createFindByNameResponse(FindByNameResponse value) {
        return new JAXBElement<FindByNameResponse>(_FindByNameResponse_QNAME, FindByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.employeeprovider.com/", name = "findEmployee")
    public JAXBElement<FindEmployee> createFindEmployee(FindEmployee value) {
        return new JAXBElement<FindEmployee>(_FindEmployee_QNAME, FindEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.employeeprovider.com/", name = "findEmployeeResponse")
    public JAXBElement<FindEmployeeResponse> createFindEmployeeResponse(FindEmployeeResponse value) {
        return new JAXBElement<FindEmployeeResponse>(_FindEmployeeResponse_QNAME, FindEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.employeeprovider.com/", name = "removeEmployee")
    public JAXBElement<RemoveEmployee> createRemoveEmployee(RemoveEmployee value) {
        return new JAXBElement<RemoveEmployee>(_RemoveEmployee_QNAME, RemoveEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.employeeprovider.com/", name = "removeEmployeeResponse")
    public JAXBElement<RemoveEmployeeResponse> createRemoveEmployeeResponse(RemoveEmployeeResponse value) {
        return new JAXBElement<RemoveEmployeeResponse>(_RemoveEmployeeResponse_QNAME, RemoveEmployeeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmployee }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.employeeprovider.com/", name = "updateEmployee")
    public JAXBElement<UpdateEmployee> createUpdateEmployee(UpdateEmployee value) {
        return new JAXBElement<UpdateEmployee>(_UpdateEmployee_QNAME, UpdateEmployee.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateEmployeeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.employeeprovider.com/", name = "updateEmployeeResponse")
    public JAXBElement<UpdateEmployeeResponse> createUpdateEmployeeResponse(UpdateEmployeeResponse value) {
        return new JAXBElement<UpdateEmployeeResponse>(_UpdateEmployeeResponse_QNAME, UpdateEmployeeResponse.class, null, value);
    }

}
