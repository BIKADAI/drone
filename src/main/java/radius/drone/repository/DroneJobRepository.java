package radius.drone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import radius.drone.entity.DroneJob;

public interface DroneJobRepository  extends JpaRepository<DroneJob, Integer>{
	
    @Query(value="select * from drone_job where drone_id=:drone order by id desc limit 1 ", nativeQuery=true)
	DroneJob findLastJob(@Param("drone") String drone);

}
