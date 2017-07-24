package com.gmail.babanin.aleksey;

import java.util.ArrayList;

public class BlackList {
    private ArrayList<Class<?>> list = new ArrayList<>();

    public BlackList() {
        super();
    }

    public void addClass(Class<?>... c) {
        for (Class<?> classes : c) {
            list.add(classes);
        }
    }
    
    public boolean inList(Class<?> c) {
        for (Class<?> classes : list) {
            if (classes == c) {
                return true;
            }
        }
        return false;
    }
    
}
