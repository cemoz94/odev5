package kodlama.io.programmingLang.business.abstracts;

import java.util.List;

import kodlama.io.programmingLang.business.requests.technologyrequests.CreateTechnologyRequest;
import kodlama.io.programmingLang.business.requests.technologyrequests.DeleteTechnologyRequest;
import kodlama.io.programmingLang.business.requests.technologyrequests.UpdateTechnologyRequest;
import kodlama.io.programmingLang.business.responses.technologyresponses.GetAllTechnologyResponse;

public interface TechnologyService {
	List<GetAllTechnologyResponse> getAll();
	void add(CreateTechnologyRequest createTechnologyRequest);
	void update(UpdateTechnologyRequest udateTechnologyRequest, int id);
	void delete(DeleteTechnologyRequest deleteTechnologyRequest);

}
