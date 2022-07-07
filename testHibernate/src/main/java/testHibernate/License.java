package testHibernate;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class License {

	private int id;
	
	private String licenseNumber;
	private Date issueDate;
}
