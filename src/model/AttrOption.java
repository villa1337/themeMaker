package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
@XmlAccessorType(XmlAccessType.FIELD)
public class AttrOption {

    @XmlAttribute private String name;
    @XmlElement  private Value value;
    @XmlAttribute private String baseAttributes;


    public String getBaseAttributes() {
        return baseAttributes;
    }

    public void setBaseAttributes(String baseAttributes) {
        this.baseAttributes = baseAttributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
