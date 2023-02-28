package radius.drone.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import radius.drone.entity.Drone;
import radius.drone.form.DroneDTO;
import radius.drone.repository.DroneRepository;

@Component
public class DroneValidator implements Validator{
	
	@Autowired
	private DroneRepository droneRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return DroneDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors e) {
		 DroneDTO form = (DroneDTO)target;
		 Drone drone = droneRepository.findBySerialNumber(form.getSerialNumber());
		 if(form.getSerialNumber().length()>100 || form.getSerialNumber().length()==0)
		 e.rejectValue("serialNumber", "INVALID SERIAL NUMBER LENGTH");
		 if(drone!=null)
		 e.rejectValue("serialNumber duplicate", "DUPLICATE SERIAL NUMBER");
		 if(form.getWeight()>500 || form.getWeight()<=0)
		 e.rejectValue("Drone weight", "INVALID DRONE WEIGHT");
		 if(form.getCurrentBattery()>100 || form.getCurrentBattery()<0)
		 e.rejectValue("Drone battery", "INVALID BATTERY PERCENTAGE");
		 
	}

}
