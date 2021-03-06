package com.biz.iolist.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO {
	
	private long io_seq;
	
	private String io_pname;
	
	private String io_date;
	private String io_time;
	
	private boolean io_input;
	
	private int io_price;
	private int io_quan;
	private int io_total;
	
	private int io_iprice;       
	private int io_oprice;       
    

    private int io_iprice_sum;       
    private int io_oprice_sum;       
    
	
	
	


}
