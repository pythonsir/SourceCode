
package com.example.demo.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>UserType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="UserType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="header" type="{http://manzj.net/services/test}userHeaderType"/&gt;
 *         &lt;element name="body" type="{http://manzj.net/services/test}userBodyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserType", propOrder = {
    "header",
    "body"
})
public class UserType {

    @XmlElement(required = true)
    protected UserHeaderType header;
    @XmlElement(required = true)
    protected UserBodyType body;

    /**
     * 获取header属性的值。
     * 
     * @return
     *     possible object is
     *     {@link UserHeaderType }
     *     
     */
    public UserHeaderType getHeader() {
        return header;
    }

    /**
     * 设置header属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link UserHeaderType }
     *     
     */
    public void setHeader(UserHeaderType value) {
        this.header = value;
    }

    /**
     * 获取body属性的值。
     * 
     * @return
     *     possible object is
     *     {@link UserBodyType }
     *     
     */
    public UserBodyType getBody() {
        return body;
    }

    /**
     * 设置body属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link UserBodyType }
     *     
     */
    public void setBody(UserBodyType value) {
        this.body = value;
    }

}
