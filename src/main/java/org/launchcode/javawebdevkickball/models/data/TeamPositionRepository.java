package org.launchcode.javawebdevkickball.models.data;

import org.launchcode.javawebdevkickball.models.TeamPosition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TeamPositionRepository extends CrudRepository<TeamPosition, Integer> {
}
