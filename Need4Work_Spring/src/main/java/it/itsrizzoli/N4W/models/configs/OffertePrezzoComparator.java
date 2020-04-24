package it.itsrizzoli.N4W.models.configs;

import java.util.Comparator;

import it.itsrizzoli.N4W.models.db.Offerta;

public class OffertePrezzoComparator implements Comparator<Offerta>{

	@Override
	public int compare(Offerta o1, Offerta o2) {
		int retVal=0;
		if (o1.getPrezzo()<o2.getPrezzo())
			retVal=-1;
		else
			retVal=11;
		return retVal;
	}

}
