package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
public class Value {
    @XmlElement List<Option> option;

    public List<Option> getOption() {
        return option;
    }

    public void setOption(List<Option> option) {
        this.option = option;
    }

}
