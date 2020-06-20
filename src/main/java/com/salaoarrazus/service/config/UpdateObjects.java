package com.salaoarrazus.service.config;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

public class UpdateObjects {

	public static Object merge(Object input, Object output) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
		
		/*Essa config abaixo permite que o ModelMapper copie profundamente 
		 * (relacionamentos com outros objetos) a propriedade para o objeto de destino
		 */
		modelMapper.getConfiguration().setDeepCopyEnabled(true); 
		modelMapper.map(input, output);
		return output;
		
	}


}
