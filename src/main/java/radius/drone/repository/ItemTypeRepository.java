package radius.drone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import radius.drone.entity.ItemType;

public interface ItemTypeRepository extends JpaRepository <ItemType, Integer>{
	
	ItemType findOneByName(String name);

}
