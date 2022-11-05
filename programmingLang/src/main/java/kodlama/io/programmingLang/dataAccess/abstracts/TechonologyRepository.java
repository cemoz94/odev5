package kodlama.io.programmingLang.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlama.io.programmingLang.entities.concretes.Technology;

public interface TechonologyRepository extends JpaRepository<Technology, Integer> {

}
