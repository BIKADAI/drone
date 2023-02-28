package radius.drone.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import radius.drone.form.ItemDTO;

@Component
public class ItemDTOValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return ItemDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors e) {
		// TODO Auto-generated method stub
		
		ItemDTO item = (ItemDTO)target;
		if(Pattern.matches("[\\w\\-\\_]", item.getName()))
		e.rejectValue("Item  name", "INVALID CHARACTER IN ITEM NAME");
		if(Pattern.matches("[A-Z\\_\\0-9]", item.getCode()))
		e.rejectValue("Item  code", "INVALID CHARACTER IN ITEM CODE");		
		
	}

}
