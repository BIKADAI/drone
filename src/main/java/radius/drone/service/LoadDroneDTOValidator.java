package radius.drone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import radius.drone.entity.Drone;
import radius.drone.form.ItemDTO;
import radius.drone.form.LoadDroneDTO;
import radius.drone.repository.DroneRepository;

@Component
public class LoadDroneDTOValidator implements Validator{
	
	@Autowired
	DroneRepository droneRepository;
	
	@Autowired
	private ItemDTOValidator itemDTOValidator;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return LoadDroneDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors e) {
		// TODO Auto-generated method stub
		LoadDroneDTO form =(LoadDroneDTO) target;
		String serialNumber= form.getSerialNumber();
		Drone drone = droneRepository.findBySerialNumber(serialNumber);
		if(drone==null)  e.rejectValue("serialNumber", " SERIAL NUMBER NOT FOUND");
		
		List<ItemDTO> items = form.getItems();
		for(ItemDTO item:items) {
			itemDTOValidator.validate(item, e);
		}
		
	}

}
