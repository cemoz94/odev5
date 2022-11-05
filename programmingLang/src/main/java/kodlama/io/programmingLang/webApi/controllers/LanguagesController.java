package kodlama.io.programmingLang.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.programmingLang.business.abstracts.LanguageService;
import kodlama.io.programmingLang.business.requests.languageresquests.CreateLanguageRequest;
import kodlama.io.programmingLang.business.requests.languageresquests.DeleteLanguageRequest;
import kodlama.io.programmingLang.business.requests.languageresquests.UpdateLanguageRequest;
import kodlama.io.programmingLang.business.responses.languageresponses.GetAllLanguagesResponse;
import kodlama.io.programmingLang.business.responses.languageresponses.GetByIdLangauageResponse;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	private LanguageService languageService;

	@Autowired
	public LanguagesController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping("/getAll")
	public List<GetAllLanguagesResponse> getAll(){
		return languageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest) {
		this.languageService.add(createLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteLanguageRequest deleteLanguageRequest) {
		this.languageService.delete(deleteLanguageRequest);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody UpdateLanguageRequest updateLanguageRequest, int id) {
		this.languageService.update(updateLanguageRequest, id);
	}
	
	@GetMapping("/getById")
	public GetByIdLangauageResponse getById(@PathVariable int id) {
		return languageService.getById(id);
	}
	
}
