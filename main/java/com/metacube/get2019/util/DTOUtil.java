package com.metacube.get2019.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOUtil {
public static ModelMapper mapper;
	
	@Autowired
	public DTOUtil(ModelMapper modelMapper) {
		mapper = modelMapper;
	}
	public static <S, T> T map(S source, Class<T> targetClass) {
		return mapper.map(source, targetClass);
	}
}
