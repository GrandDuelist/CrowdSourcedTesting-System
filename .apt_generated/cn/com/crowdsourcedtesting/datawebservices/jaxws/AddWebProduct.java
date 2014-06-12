
package cn.com.crowdsourcedtesting.datawebservices.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "addWebProduct", namespace = "http://datawebservices.crowdsourcedtesting.com.cn/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addWebProduct", namespace = "http://datawebservices.crowdsourcedtesting.com.cn/", propOrder = {
    "productName",
    "icon",
    "webLink",
    "description"
})
public class AddWebProduct {

    @XmlElement(name = "productName", namespace = "")
    private String productName;
    @XmlElement(name = "icon", namespace = "")
    private String icon;
    @XmlElement(name = "webLink", namespace = "")
    private String webLink;
    @XmlElement(name = "description", namespace = "")
    private String description;

    /**
     * 
     * @return
     *     returns String
     */
    public String getProductName() {
        return this.productName;
    }

    /**
     * 
     * @param productName
     *     the value for the productName property
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getIcon() {
        return this.icon;
    }

    /**
     * 
     * @param icon
     *     the value for the icon property
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getWebLink() {
        return this.webLink;
    }

    /**
     * 
     * @param webLink
     *     the value for the webLink property
     */
    public void setWebLink(String webLink) {
        this.webLink = webLink;
    }

    /**
     * 
     * @return
     *     returns String
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * 
     * @param description
     *     the value for the description property
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
