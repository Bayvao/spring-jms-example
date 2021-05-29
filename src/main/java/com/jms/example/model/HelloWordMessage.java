package com.jms.example.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HelloWordMessage implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String message;
}
