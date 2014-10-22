package com.teamin.batch.chunk;

import java.util.List;
import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Named
public class morgenBroedItemWriter extends AbstractItemWriter {

    @PersistenceContext
    EntityManager em;

    @Override
    public void writeItems(List<Object> list) throws Exception{
        for (Object item : list) {
            em.merge(item);
        }
    }
}