package pl.usa.model.gamer;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.usa.model.core.AbstractEntity;
import pl.usa.model.core.IEntity;

@Data
@EqualsAndHashCode(of="id")
@Entity
@Table(name="users")
public class User extends AbstractEntity implements IEntity {

	private static final long serialVersionUID = 3382321891169723841L;

	@Column(nullable=false, unique=true)
	private String email;

	@Column(nullable=false)
	private String password;

	@Transient
	private String repeatedPassword;

	private String role;

	@Column(name="create_date", updatable=false)
	private Date dateCreate;

	@Column(name="last_login_date")
	private Date lastLoginDate;

	@OneToOne(mappedBy="user", fetch=EAGER, cascade=ALL)
	private UserProfile profile;

	@OneToOne(mappedBy="user", fetch=EAGER, cascade=ALL)
	private Character character;


	@PrePersist
	protected void onCreate() {
		dateCreate = new Date();
		role = "ROLE_USER";
	}
}
