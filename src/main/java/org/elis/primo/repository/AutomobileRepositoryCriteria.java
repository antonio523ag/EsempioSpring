package org.elis.primo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.elis.primo.model.Automobile;
import org.elis.primo.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class AutomobileRepositoryCriteria {

    private final EntityManager em;

    public List<Automobile> getAutomobili(Map<String,Object> params){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Automobile> cq= builder.createQuery(Automobile.class);
        Root<Automobile> root = cq.from(Automobile.class);
        Join<Automobile, Persona>  join = root.join("proprietario");
        Predicate[] arrayPredicati= new Predicate[params.size()];
        int pos=0;
        for(String key:params.keySet()){
            var value=params.get(key);
            Predicate temp;
            if(key.equals("nome")||
                    key.equals("cognome")||
                    key.equals("email")){
                temp=builder.equal(join.get(key),value);
            }else{
                temp=builder.equal(root.get(key),value);
            }
            arrayPredicati[pos++]=temp;
        }
        cq.where(arrayPredicati);
        TypedQuery<Automobile> query = em.createQuery(cq);
        return query.getResultList();

    }
}
