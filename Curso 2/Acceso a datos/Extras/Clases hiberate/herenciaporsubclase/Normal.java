package org.dam2.herenciaporsubclase;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

@Entity
public class Normal extends Persona
{

    private String ocupacion;

    
    
}
