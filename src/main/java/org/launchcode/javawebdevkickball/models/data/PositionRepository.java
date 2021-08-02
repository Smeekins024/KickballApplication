package org.launchcode.javawebdevkickball.models.data;

import org.launchcode.javawebdevkickball.models.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PositionRepository extends CrudRepository<Position, Integer> {
}
