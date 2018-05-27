package data.submission;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Submission class from user. Holds configuration restrictions.
 * @author skner
 *
 */
public class Restrictions {
	@JsonProperty("restrictionsList") private List<RestrictionsList> restrictionsList;

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
