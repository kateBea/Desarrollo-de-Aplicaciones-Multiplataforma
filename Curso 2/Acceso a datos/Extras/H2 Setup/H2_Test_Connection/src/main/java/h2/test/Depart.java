package h2.test;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded=true)

public class Depart {

	@EqualsAndHashCode.Include
	private String deptNo;
	private String dname;
	private String loc;	
	private LocalDate fechaCreacion;
}
