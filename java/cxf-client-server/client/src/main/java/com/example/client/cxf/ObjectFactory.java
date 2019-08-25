
package com.example.client.cxf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.client.cxf package. 
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

    private final static QName _ReqHeader_QNAME = new QName("http://manzj.net/services/test", "ReqHeader");
    private final static QName _RspHeader_QNAME = new QName("http://manzj.net/services/test", "RspHeader");
    private final static QName _User_QNAME = new QName("http://manzj.net/services/test", "User");
    private final static QName _ResUser_QNAME = new QName("http://manzj.net/services/test", "resUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.client.cxf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReqHeaderType }
     * 
     */
    public ReqHeaderType createReqHeaderType() {
        return new ReqHeaderType();
    }

    /**
     * Create an instance of {@link RspHeaderType }
     * 
     */
    public RspHeaderType createRspHeaderType() {
        return new RspHeaderType();
    }

    /**
     * Create an instance of {@link UserType }
     * 
     */
    public UserType createUserType() {
        return new UserType();
    }

    /**
     * Create an instance of {@link ResUserType }
     * 
     */
    public ResUserType createResUserType() {
        return new ResUserType();
    }

    /**
     * Create an instance of {@link UserHeaderType }
     * 
     */
    public UserHeaderType createUserHeaderType() {
        return new UserHeaderType();
    }

    /**
     * Create an instance of {@link UserBodyType }
     * 
     */
    public UserBodyType createUserBodyType() {
        return new UserBodyType();
    }

    /**
     * Create an instance of {@link ResUserHeaderType }
     * 
     */
    public ResUserHeaderType createResUserHeaderType() {
        return new ResUserHeaderType();
    }

    /**
     * Create an instance of {@link ResUserBodyType }
     * 
     */
    public ResUserBodyType createResUserBodyType() {
        return new ResUserBodyType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReqHeaderType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ReqHeaderType }{@code >}
     */
    @XmlElementDecl(namespace = "http://manzj.net/services/test", name = "ReqHeader")
    public JAXBElement<ReqHeaderType> createReqHeader(ReqHeaderType value) {
        return new JAXBElement<ReqHeaderType>(_ReqHeader_QNAME, ReqHeaderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RspHeaderType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RspHeaderType }{@code >}
     */
    @XmlElementDecl(namespace = "http://manzj.net/services/test", name = "RspHeader")
    public JAXBElement<RspHeaderType> createRspHeader(RspHeaderType value) {
        return new JAXBElement<RspHeaderType>(_RspHeader_QNAME, RspHeaderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UserType }{@code >}
     */
    @XmlElementDecl(namespace = "http://manzj.net/services/test", name = "User")
    public JAXBElement<UserType> createUser(UserType value) {
        return new JAXBElement<UserType>(_User_QNAME, UserType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResUserType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ResUserType }{@code >}
     */
    @XmlElementDecl(namespace = "http://manzj.net/services/test", name = "resUser")
    public JAXBElement<ResUserType> createResUser(ResUserType value) {
        return new JAXBElement<ResUserType>(_ResUser_QNAME, ResUserType.class, null, value);
    }

}
