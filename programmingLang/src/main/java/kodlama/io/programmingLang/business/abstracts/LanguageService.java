package kodlama.io.programmingLang.business.abstracts;

import java.util.List;

import kodlama.io.programmingLang.business.requests.languageresquests.CreateLanguageRequest;
import kodlama.io.programmingLang.business.requests.languageresquests.DeleteLanguageRequest;
import kodlama.io.programmingLang.business.requests.languageresquests.UpdateLanguageRequest;
import kodlama.io.programmingLang.business.responses.languageresponses.GetAllLanguagesResponse;
import kodlama.io.programmingLang.business.responses.languageresponses.GetByIdLangauageResponse;

public interface LanguageService {
	List<GetAllLanguagesResponse> getAll();
	void add(CreateLanguageRequest createLanguageRequest);
	GetByIdLangauageResponse getById(int id);
	void delete(DeleteLanguageRequest deleteLanguageRequest);
	void update(UpdateLanguageRequest updateLanguageRequest, int id);

}
