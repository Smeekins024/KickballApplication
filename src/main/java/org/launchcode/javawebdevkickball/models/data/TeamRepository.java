package org.launchcode.javawebdevkickball.models.data;

import org.launchcode.javawebdevkickball.models.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TeamRepository extends CrudRepository<Team,Integer>{
}


