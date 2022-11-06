package kodlama.io.programmingLang.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.programmingLang.business.abstracts.TechnologyService;
import kodlama.io.programmingLang.business.requests.technologyrequests.CreateTechnologyRequest;
import kodlama.io.programmingLang.business.requests.technologyrequests.DeleteTechnologyRequest;
import kodlama.io.programmingLang.business.requests.technologyrequests.UpdateTechnologyRequest;
import kodlama.io.programmingLang.business.responses.technologyresponses.GetAllTechnologyResponse;
import kodlama.io.programmingLang.dataAccess.abstracts.LanguageRepository;
import kodlama.io.programmingLang.dataAccess.abstracts.TechonologyRepository;
import kodlama.io.programmingLang.entities.concretes.Language;
import kodlama.io.programmingLang.entities.concretes.Technology;
@Service
public class TechnologyManager implements TechnologyService{
	private TechonologyRepository techonologyRepository;
	private LanguageRepository languageRepository;

	@Autowired
	public TechnologyManager(LanguageRepository languageRepository, TechonologyRepository techonologyRepository) {
		this.techonologyRepository = techonologyRepository;
		this.languageRepository = languageRepository;
	}
	
	@Override
	public List<GetAllTechnologyResponse> getAll() {
		
		List<Technology> technologies = techonologyRepository.findAll();
		List<GetAllTechnologyResponse> technologyResponse = new ArrayList<GetAllTechnologyResponse>();
		
		for (Technology technology : technologies) {
			GetAllTechnologyResponse responseItem = new GetAllTechnologyResponse();
		responseItem.setId(technology.getId());
		responseItem.setName(technology.getName());
		technologyResponse.add(responseItem);
		}
		return technologyResponse;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		Technology technology = new Technology();
		technology.setName(createTechnologyRequest.getName());
		this.techonologyRepository.save(technology);
	}

	@Override
	public void update(UpdateTechnologyRequest updateTechnologyRequest, int id) {
		Technology technology = techonologyRepository.findById(id).get();
		Language language = languageRepository.findById(updateTechnologyRequest.getLanguageId()).get();
		
		technology.setName(updateTechnologyRequest.getName());
		technology.setLanguage(language);
		techonologyRepository.save(technology);
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
		techonologyRepository.deleteById(deleteTechnologyRequest.getId());
		
	}




}
