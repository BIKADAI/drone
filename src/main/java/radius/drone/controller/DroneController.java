package radius.drone.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import radius.drone.entity.Drone;
import radius.drone.entity.DroneJob;
import radius.drone.entity.DroneLoadedItem;
import radius.drone.entity.ItemType;
import radius.drone.form.DroneDTO;
import radius.drone.form.ItemDTO;
import radius.drone.form.LoadDroneDTO;
import radius.drone.repository.DroneRepository;
import radius.drone.repository.ItemTypeRepository;
import radius.drone.service.DroneValidator;
import radius.drone.service.LoadDroneDTOValidator;
import radius.drone.util.DroneState;

@RestController
@RequestMapping("/api/v1")
public class DroneController {
	
	@Autowired
	private DroneRepository droneRepository;
	
	@Autowired
	private ItemTypeRepository itemTypeRepository;
	
	@Autowired
    private DroneValidator droneValidator;
	
	@Autowired
    private LoadDroneDTOValidator loadDroneDTOValidator;
	
    @InitBinder(value = "droneDTO")
    void initDrone(WebDataBinder binder) {
        binder.setValidator(droneValidator);
    }
    
    @InitBinder(value = "loadDroneDTO")
    void initLoading(WebDataBinder binder) {
        binder.setValidator(loadDroneDTOValidator);
    }
    
	@RequestMapping(value="/register", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registerDrone(@RequestBody @Valid  DroneDTO droneDTO){
		Map<String , Object> result = new HashMap<String, Object>();
		result.put("status", "SUCCESS");
		result.put("message", "Entity created successfully");
		Drone drone = new Drone();
		drone.setCurrentBattery(droneDTO.getCurrentBattery());
		drone.setModel(droneDTO.getModel());
		drone.setState(droneDTO.getState());
		drone.setWeight(droneDTO.getWeight());
		drone.setSerialNumber(droneDTO.getSerialNumber());
		
		droneRepository.save(drone);
		return new ResponseEntity<Object>(result, HttpStatus.CREATED);
	}

	@RequestMapping(value="/load", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> loadDrone(@RequestBody @Valid  LoadDroneDTO items){
		Map<String , Object> result = new HashMap<String, Object>();
		Drone droneToLoad =droneRepository.findBySerialNumber(items.getSerialNumber());
		DroneState droneState =droneToLoad.getState();
		int totalLoad=0;
		for(ItemDTO item:items.getItems()) {
			 totalLoad+=item.getQuantity()*item.getWeight();
		}
		if((droneState!=DroneState.IDLE)||droneToLoad.getWeight()<totalLoad || droneToLoad.getCurrentBattery()<25) {
			result.put("status", "FAILED");
			result.put("message", "The drone can not be loaded due to project constraints");	
			return new ResponseEntity<Object>(result, HttpStatus.CREATED);

		}
		/*
		 * start to load drone
		 */
		List<DroneLoadedItem> itemsToLoad= new ArrayList<DroneLoadedItem>();
		DroneJob job= new DroneJob();
		ItemType itemType=itemTypeRepository.findOneByName("medications");
		job.setStartingDate(new Date());
		job.setBatteryLevel(droneToLoad.getCurrentBattery());
		
		
		
		for(ItemDTO itemDTO:items.getItems()) {
			DroneLoadedItem item=new DroneLoadedItem();
			item.setCode(itemDTO.getCode());
			item.setImage(itemDTO.getImage());
			item.setName(itemDTO.getName());
			item.setQuantity(itemDTO.getQuantity());
			item.setWeight(itemDTO.getWeight());
			item.setItemType(itemType);
			itemsToLoad.add(item);
			
		}
		job.setDroneLoadedItems(itemsToLoad);
		job.setDrone(droneToLoad);
		droneRepository.save(droneToLoad);
		result.put("status", "SUCCESS");
		result.put("message", "Entity created successfully");
		return new ResponseEntity<Object>(result, HttpStatus.CREATED);
	}

}
