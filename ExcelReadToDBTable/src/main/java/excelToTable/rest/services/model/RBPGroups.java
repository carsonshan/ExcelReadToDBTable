package excelToTable.rest.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
    @NamedQuery(name = "RBPGroups.findAll", query = "SELECT re FROM RBPGroups re"),
    @NamedQuery(name = "RBPGroups.updateAll", query = "UPDATE RBPGroups SET flag = 1"),
    @NamedQuery(name = "RBPGroups.deleteFlagged", query = "DELETE FROM RBPGroups WHERE flag = 1")
})
public class RBPGroups {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Column
	private String userId;
	@Column
	private String role;
	@Column
	private String grp;
	@Column
	private int flag;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getGrp() {
		return grp;
	}
	public void setGrp(String grp) {
		this.grp = grp;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

}
