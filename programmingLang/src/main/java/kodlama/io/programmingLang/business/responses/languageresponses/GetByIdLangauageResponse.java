package kodlama.io.programmingLang.business.responses.languageresponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdLangauageResponse {
	private int id;
	private String name;

}
