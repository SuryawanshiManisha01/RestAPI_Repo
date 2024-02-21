package com.nit.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Place {
	
	private String id;
    private String name;
    private String address;
  
    private GeoLocation location;

}
