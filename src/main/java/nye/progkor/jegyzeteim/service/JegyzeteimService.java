package nye.progkor.jegyzeteim.service;

import java.util.List;

import nye.progkor.jegyzeteim.model.Jegyzeteim;

public interface JegyzeteimService {

	List<Jegyzeteim> getAllJegyzeteim();
	
	Jegyzeteim getJegyzeteim(Long id);
	
	Jegyzeteim createJegyzeteim(Jegyzeteim jegyzeteim);
	
	Jegyzeteim updateJegyzeteim(Long id, Jegyzeteim jegyzeteimChange);
	
	void deleteJegyzeteim(Long id);
	
	
}
