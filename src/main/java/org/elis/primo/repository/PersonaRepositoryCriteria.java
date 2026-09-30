package org.elis.primo.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.elis.primo.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonaRepositoryCriteria {

    private final EntityManager em;

    public List<Persona> getPersoneByText(String text){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Persona> cq= builder.createQuery(Persona.class);
        Root<Persona> root = cq.from(Persona.class);
        Predicate p1=builder.like(root.get("nome"), "%"+text+"%");
        Predicate p2=builder.like(root.get("cognome"), "%"+text+"%");
        Predicate p3=builder.like(root.get("email"), "%"+text+"%");
        Predicate complessivo=builder.or(p1,p2,p3);
        cq.where(complessivo);
        TypedQuery<Persona> query = em.createQuery(cq);
        return query.getResultList();
    }
}
