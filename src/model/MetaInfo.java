package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
public class MetaInfo {

    @XmlElement private List<Property> property;

    public List<Property> getProperties() {
        return property;
    }

    public void setProperties(List<Property> property) {
        this.property = property;
    }
}
