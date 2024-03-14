package org.dam2.mongonoticias;

import org.dam2.mongonoticias.modelo.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;


public class NoticiaCascadeSaveMongoEventListener extends AbstractMongoEventListener<Noticia> {

	@Autowired
    private MongoOperations mongoOperations;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Noticia> event) { 
    	
        Noticia source = event.getSource();
        
        if (source.getRedactor() != null) { 
            mongoOperations.save(source.getRedactor());
        }
        
        System.out.println("guardando noticia...");
        System.out.println(source);
    }
    
    
}
