package kodlama.io.programmingLang.webApi.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.programmingLang.business.abstracts.TechnologyService;
import kodlama.io.programmingLang.business.requests.technologyrequests.CreateTechnologyRequest;
import kodlama.io.programmingLang.business.requests.technologyrequests.DeleteTechnologyRequest;
import kodlama.io.programmingLang.business.requests.technologyrequests.UpdateTechnologyRequest;
import kodlama.io.programmingLang.business.responses.technologyresponses.GetAllTechnologyResponse;

@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {
	private TechnologyService technologyService;

	@Autowired
	public TechnologiesController(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	@GetMapping("/getAll")
	public List<GetAllTechnologyResponse> getAll(){
		return technologyService.getAll();
	}
	@PostMapping("/add")
	public void add(@RequestBody CreateTechnologyRequest createLanguageRequest) {
		this.technologyService.add(createLanguageRequest);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteTechnologyRequest deleteTechnologyRequest) {
		technologyService.delete(deleteTechnologyRequest);
	}
	
	@PutMapping("/update")
	public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
		this.technologyService.update(updateTechnologyRequest, id);
	}


}
