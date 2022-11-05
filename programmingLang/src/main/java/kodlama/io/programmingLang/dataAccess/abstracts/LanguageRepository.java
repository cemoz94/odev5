package kodlama.io.programmingLang.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.programmingLang.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer>{

}
