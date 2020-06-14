package com.salaoarrazus.service.config;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

public class UpdateObjects {

	public static Object merge(Object input, Object output) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		modelMapper.map(input, output);
		return output;
		
	}
}
