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
    @NamedQuery(name = "RBPEmployees.findAll", query = "SELECT re FROM RBPEmployees re"),
    @NamedQuery(name = "RBPEmployees.updateAll", query = "UPDATE RBPEmployees SET flag = 1"),
    @NamedQuery(name = "RBPEmployees.deleteFlagged", query = "DELETE FROM RBPEmployees WHERE flag = 1")
})
public class RBPEmployees {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	@Column
	private String userId;
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

