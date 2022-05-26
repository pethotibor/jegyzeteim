package nye.progkor.jegyzeteim.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nye.progkor.jegyzeteim.model.Jegyzeteim;

import nye.progkor.jegyzeteim.model.exception.NotFoundException;
import nye.progkor.jegyzeteim.service.JegyzeteimService;

@Service
public class JegyzeteimServiceImpl implements JegyzeteimService {

	private final List<Jegyzeteim> dataBase = new ArrayList<>();

	@Autowired
	public JegyzeteimServiceImpl() {
		dataBase.add(new Jegyzeteim(1L, "Megnezendo filmek", "A galaxis őrzői\nFlash - A Villám\nLegenda vagyok"));
		dataBase.add(new Jegyzeteim(2L, "Bevaslo lista", "Tej\nCukor\nTojas\nKenyer"));
	}

	public JegyzeteimServiceImpl(final List<Jegyzeteim> jegyzeteim) {
		dataBase.addAll(jegyzeteim);
	}

	@Override
	public List<Jegyzeteim> getAllJegyzeteim() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableList(dataBase);
	}

	@Override
	public Jegyzeteim getJegyzeteim(final Long id) {
		// TODO Auto-generated method stub
		return dataBase.stream()
				.filter(jegyzeteim -> jegyzeteim.getId().equals(id))
				.findFirst()
				.orElseThrow(NotFoundException::new);
	}

	@Override
	public Jegyzeteim createJegyzeteim(final Jegyzeteim jegyzeteim) {
		jegyzeteim.setId(getNextId());
		dataBase.add(jegyzeteim);
		return jegyzeteim;
	}

	@Override
	public Jegyzeteim updateJegyzeteim(final Long id, final Jegyzeteim jegyzeteimChange) {
		final Jegyzeteim jegyzeteim = getJegyzeteim(id);
		jegyzeteim.setTitle(jegyzeteim.getTitle());
		jegyzeteim.setNote(jegyzeteim.getNote());
		return jegyzeteim;
	}

	@Override
	public void deleteJegyzeteim(final Long id) {
		final Jegyzeteim jegyzeteim = getJegyzeteim(id);
		dataBase.remove(jegyzeteim);

	}

	private long getNextId() {
		return getLastId() + 1L;
	}

	private long getLastId() {
		return dataBase.stream()
				.mapToLong(Jegyzeteim::getId)
				.max()
				.orElse(0);
	}

}
