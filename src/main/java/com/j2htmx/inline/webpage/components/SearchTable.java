package com.j2htmx.inline.webpage.components;

import com.j2htmx.inline.html.standard.table.TD;
import com.j2htmx.inline.html.standard.table.TR;
import com.j2htmx.inline.html.standard.table.Table;

import java.util.List;

public class SearchTable extends Table {

    @Override
    public void addData(List<String> bodyData) {

        TR heads=new TR();
        for(String data : bodyData) {
            if(heads.getContent()!=null)
            {
                TD heading=new TD();
                heading.setClass("fade-content");
                heading.setContent(data);
                heads.setContent(heads.getContent()+heading.createPairNode());
            }
            else {
                TD heading=new TD();
                heading.setContent(data);
                heading.setClass("fade-content");
                heads.setContent(heading.createPairNode());
            }
        }
        setContent(getContent()+heads.createPairNode());
    }

}

