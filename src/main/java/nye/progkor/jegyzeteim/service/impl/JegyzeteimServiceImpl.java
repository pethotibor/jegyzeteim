package nye.progkor.jegyzeteim.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nye.progkor.jegyzeteim.model.Jegyzeteim;

import nye.progkor.jegyzeteim.model.exception.NotFoundException;
import nye.progkor.jegyzeteim.service.JegyzeteimService;



public class JegyzeteimServiceImpl implements JegyzeteimService{

	public static final List<Jegyzeteim> DATA_BASE = new ArrayList<>();
	
	static {
		DATA_BASE.add(new Jegyzeteim(1L, "Megnezendo filmek", "A galaxis őrzői\nFlash - A Villám\nLegenda vagyok"));
		DATA_BASE.add(new Jegyzeteim(2L, "Bevaslo lista", "Tej\nCukor\nTojas\nKenyer"));

	}
	
	
	@Override
	public List<Jegyzeteim> getAllJegyzeteim() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(DATA_BASE);
	}

	@Override
	public Jegyzeteim getJegyzeteim(Long id) {
		// TODO Auto-generated method stub
		return DATA_BASE.stream()
				.filter(jegyzeteim -> jegyzeteim.getId().equals(id))
				.findFirst()
				.orElseThrow(NotFoundException::new));
	}

	@Override
	public Jegyzeteim createJegyzeteim(Jegyzeteim jegyzeteim) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jegyzeteim updateJegyzeteim(Long id, Jegyzeteim jegyzeteimChange) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteJegyzeteim(Long id) {
		// TODO Auto-generated method stub
		
	}

}
