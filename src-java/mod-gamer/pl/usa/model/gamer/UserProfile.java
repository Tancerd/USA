package pl.usa.model.gamer;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import pl.usa.model.core.AbstractEntity;
import pl.usa.model.core.IEntity;

@Data
@EqualsAndHashCode(of="id")
@Entity
@Table(name="profile")
public class UserProfile extends AbstractEntity implements IEntity {

	private static final long serialVersionUID = -7992829458221775553L;

	@Column(nullable=false)
	private String name;

	private String lastname;

	@Column(nullable=false, unique=true)
	private String nick;

	@Column(name="phone_number")
	private String phoneNumber;

	@Column(name="private_page_url")
	private String privatePageUrl;

	@Column(name="sex")
	@Enumerated(STRING)
	private Gender gender;

	private String description;

	@OneToOne(fetch=EAGER)
	@JoinColumn(name="user_id")
	@ForeignKey(name="user_to_profile")
	@Index(name="user_profile_idx")
	private User user;

}
