
package com.example.demo.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>resUserType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="resUserType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="header" type="{http://manzj.net/services/test}resUserHeaderType"/&gt;
 *         &lt;element name="body" type="{http://manzj.net/services/test}resUserBodyType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resUserType", propOrder = {
    "header",
    "body"
})
public class ResUserType {

    @XmlElement(required = true)
    protected ResUserHeaderType header;
    @XmlElement(required = true)
    protected ResUserBodyType body;

    /**
     * 获取header属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ResUserHeaderType }
     *     
     */
    public ResUserHeaderType getHeader() {
        return header;
    }

    /**
     * 设置header属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ResUserHeaderType }
     *     
     */
    public void setHeader(ResUserHeaderType value) {
        this.header = value;
    }

    /**
     * 获取body属性的值。
     * 
     * @return
     *     possible object is
     *     {@link ResUserBodyType }
     *     
     */
    public ResUserBodyType getBody() {
        return body;
    }

    /**
     * 设置body属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link ResUserBodyType }
     *     
     */
    public void setBody(ResUserBodyType value) {
        this.body = value;
    }

}
