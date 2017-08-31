package com.uciext.springfw.hw.catalog.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "catalogList")
public class CatalogList {
    ArrayList<Catalog> catalogs = new ArrayList<Catalog>();

    public void setCatalogs(ArrayList<Catalog> catalogs) {
        this.catalogs = catalogs;
    }

    public ArrayList<Catalog> getCatalogs() {
        return catalogs;
    }
}
