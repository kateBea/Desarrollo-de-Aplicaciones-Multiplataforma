package org.dam2.websocket;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OutputMessage {
	 private String from;
	    private String text;
	    private LocalDate time;
}
