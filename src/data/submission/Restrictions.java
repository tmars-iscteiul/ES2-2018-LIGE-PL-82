package data.submission;

import java.util.List;

public class Restrictions {
	private List<RestrictionsList> restrictionsList;

	public Restrictions(List<RestrictionsList> restrictionsList) {
		super();
		this.restrictionsList = restrictionsList;
	}
	
	public Restrictions() {
		
	}

	public List<RestrictionsList> getRestrictionsList() {
		return restrictionsList;
	}

	public void setRestrictionsList(List<RestrictionsList> restrictionsList) {
		this.restrictionsList = restrictionsList;
	}

	
}
