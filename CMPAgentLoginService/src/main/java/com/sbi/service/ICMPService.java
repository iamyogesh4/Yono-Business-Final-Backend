package com.sbi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sbi.entity.CmpLogin;

public interface ICMPService {
	
	
	public String loginCmpProcess(CmpLogin login) throws JsonMappingException, JsonProcessingException;

}
