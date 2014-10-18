package pl.usa.model.core;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@Data
@MappedSuperclass
public abstract class AbstractEntity implements Serializable{

	private static final long serialVersionUID = 8471619099958456343L;

	@Id
	@GeneratedValue(strategy=AUTO)
	private long id;


	public boolean isSaved() {
		return id != 0;
	}
}
