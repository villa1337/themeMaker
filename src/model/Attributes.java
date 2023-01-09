package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
public class Attributes {
    @XmlElement private List<AttrOption> option;

    public List<AttrOption> getOption() {
        return option;
    }

    public void setOption(List<AttrOption> option) {
        this.option = option;
    }
}
