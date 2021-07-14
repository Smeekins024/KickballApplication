package org.launchcode.javawebdevtechjobspersistent.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.launchcode.javawebdevtechjobspersistent.models.Skill;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface SkillRepository extends CrudRepository<Skill, Integer> {
}
