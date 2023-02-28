package radius.drone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import radius.drone.entity.Drone;

public interface DroneRepository extends JpaRepository<Drone, Integer>{
 
	public Drone findBySerialNumber(String serialNumber);

}
