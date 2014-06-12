
package cn.com.crowdsourcedtesting.datawebservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "addWebProductResponse", namespace = "http://datawebservices.crowdsourcedtesting.com.cn/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addWebProductResponse", namespace = "http://datawebservices.crowdsourcedtesting.com.cn/")
public class AddWebProductResponse {

    @XmlElement(name = "return", namespace = "")
    private cn.com.crowdsourcedtesting.bean.Product _return;

    /**
     * 
     * @return
     *     returns Product
     */
    public cn.com.crowdsourcedtesting.bean.Product getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(cn.com.crowdsourcedtesting.bean.Product _return) {
        this._return = _return;
    }

}
