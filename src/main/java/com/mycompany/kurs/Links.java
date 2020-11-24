package com.mycompany.kurs;

import java.util.ArrayList;

public class Links {
    public final ArrayList<Link> links = new ArrayList<>();

    public void connect(Plumb what, Plumb whom, LinkType type) {
        Link link = new Link(what.getName(), whom.getName(), type);
        links.add(link);
    }
    
    public void disconnect(Plumb what, Plumb whom, LinkType type) {
        Link link = new Link(what.getName(), whom.getName(), type);
        for(int i = 0; i< links.size();i++){
            if(links.get(1).equals(link)) links.remove(link);
        }
    }
    
}
