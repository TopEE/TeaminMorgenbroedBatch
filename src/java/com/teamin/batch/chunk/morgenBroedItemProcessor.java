package com.teamin.batch.chunk;

import com.teamin.entity.Morgenbroed;
import java.util.StringTokenizer;
import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class morgenBroedItemProcessor implements ItemProcessor {

    @PersistenceContext
    EntityManager em;

    @Override
    public Morgenbroed processItem(Object t) {
        StringTokenizer tokens = new StringTokenizer((String) t, ",");

        String userId = tokens.nextToken();
        Morgenbroed mb = em.find(Morgenbroed.class, userId);
        
        int bestiltIalt = Integer.parseInt(tokens.nextToken()) + mb.getBestilt();
        int betaltIalt = Integer.parseInt(tokens.nextToken()) + mb.getBetalt();
        
        return new Morgenbroed(userId, bestiltIalt, betaltIalt);
    }
}
