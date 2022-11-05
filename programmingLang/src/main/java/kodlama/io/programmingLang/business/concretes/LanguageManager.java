package kodlama.io.programmingLang.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.programmingLang.business.abstracts.LanguageService;
import kodlama.io.programmingLang.business.requests.languageresquests.CreateLanguageRequest;
import kodlama.io.programmingLang.business.requests.languageresquests.DeleteLanguageRequest;
import kodlama.io.programmingLang.business.requests.languageresquests.UpdateLanguageRequest;
import kodlama.io.programmingLang.business.responses.languageresponses.GetAllLanguagesResponse;
import kodlama.io.programmingLang.business.responses.languageresponses.GetByIdLangauageResponse;
import kodlama.io.programmingLang.dataAccess.abstracts.LanguageRepository;
import kodlama.io.programmingLang.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	private LanguageRepository languageRepository;
	
	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		super();
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguagesResponse> getAll() {

		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguagesResponse> languagesResponse = new ArrayList<GetAllLanguagesResponse>();
		
		for (Language language: languages) {
			GetAllLanguagesResponse responseItem = new GetAllLanguagesResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languagesResponse.add(responseItem);
		}
		return languagesResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest){
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		this.languageRepository.save(language);
		
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest, int id) {
		if(!updateLanguageRequest.getName().isEmpty()) {
			Language language = languageRepository.findById(id).get();
			language.setName(updateLanguageRequest.getName());
			languageRepository.save(language);
		}
		
	}

	@Override
	public GetByIdLangauageResponse getById(int id) {
		Language language = languageRepository.findById(id).get();
		GetByIdLangauageResponse response = new GetByIdLangauageResponse();
		response.setName(language.getName());
		return response;
	}

	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
		languageRepository.deleteById(deleteLanguageRequest.getId());
		
	}


	


}