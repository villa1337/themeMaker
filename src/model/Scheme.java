package model;


import javax.xml.bind.annotation.*;

@XmlRootElement(name = "scheme")
@XmlAccessorType(XmlAccessType.FIELD)
public class Scheme {

    @XmlAttribute private String name;
    @XmlAttribute private String version;
    @XmlAttribute(name="parent_scheme") private String parentScheme;
    @XmlElement private MetaInfo metaInfo;
    @XmlElement private Colors colors;
    @XmlElement private Attributes attributes;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getParentScheme() {
        return parentScheme;
    }

    public void setParentScheme(String parentScheme) {
        this.parentScheme = parentScheme;
    }

    public MetaInfo getMetaInfo() {
        return metaInfo;
    }

    public void setMetaInfo(MetaInfo metaInfo) {
        this.metaInfo = metaInfo;
    }

    public Colors getColors() {
        return colors;
    }

    public void setColors(Colors colors) {
        this.colors = colors;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

}
