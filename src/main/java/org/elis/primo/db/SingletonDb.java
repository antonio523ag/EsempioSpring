package org.elis.primo.db;

import org.elis.primo.model.Automobile;

import java.util.ArrayList;
import java.util.List;

public class SingletonDb {
    //EAGER
//    private static final SingletonDb instance = new SingletonDb();
//
//    private SingletonDb(){
//        automobili=new ArrayList<>();
//    }
//
//    public static SingletonDb getInstance() {
//        return instance;
//    }

    //LAZY
    public static SingletonDb instance;

    private SingletonDb() {
        automobili=new ArrayList<>();
    }

    public static SingletonDb getInstance(){
        if(instance==null){
            instance=new SingletonDb();
        }
        return instance;
    }

    private List<Automobile> automobili;
    private static long idGenerator = 0;

    public List<Automobile> getAutomobili() {
        return automobili;
    }

    public long aggiungiAutomobile(Automobile automobile) {
        automobile.setId(++idGenerator);
        if(automobili.stream().map(Automobile::getTarga)
                .anyMatch(automobile.getTarga()::equalsIgnoreCase)) {
            return 0;
        }
        automobili.add(automobile);
        return automobile.getId();
    }

    public Automobile rimuoviAutomobile(long id) {
//        for(int i=0;i<automobili.size();i++) {
//            if(automobili.get(i).getId() == id) {
//                return automobili.remove(i);
//            }
//        }
//        return null;

        Automobile a=getAutomobileById(id);
        if(a==null)return null;
        automobili.remove(a);
        return a;
    }

    public Automobile getAutomobileById(long id) {
        return automobili.stream().
                filter(a1->a1.getId()==id)
                .findAny().orElse(null);
    }

    public Automobile getAutomobileByTarga(String targa) {
        return automobili.stream()
                .filter(a1->a1.getTarga()
                        .equalsIgnoreCase(targa))
                .findAny().orElse(null);
    }
}

