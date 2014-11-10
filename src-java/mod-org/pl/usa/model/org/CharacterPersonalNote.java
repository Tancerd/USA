package pl.usa.model.org;

import static javax.persistence.FetchType.EAGER;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.format.annotation.DateTimeFormat;

import pl.usa.model.core.AbstractEntity;
import pl.usa.model.core.IEntity;
import pl.usa.model.gamer.Character;
import pl.usa.model.gamer.User;

@Data
@EqualsAndHashCode(of="id")
@Entity
@Table(name="character_personal_note")
public class CharacterPersonalNote extends AbstractEntity implements IEntity {

	private static final long serialVersionUID = 2152507384279822484L;

	@ManyToOne(fetch = EAGER)
	@JoinColumn(name = "author_id")
	private User author;

	@ManyToOne(fetch = EAGER)
	@JoinColumn(name = "character_id")
	private Character character;

	private String note;

	@DateTimeFormat(pattern = " mm/HH dd/MM/yyyy")
	@Column(name = "date_create")
	private Date dateCreate;

	@PrePersist
	protected void onCreate() {
		dateCreate = new Date();
	}

}
