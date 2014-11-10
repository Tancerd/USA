package pl.usa.model.gamer;

import static javax.persistence.FetchType.EAGER;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import pl.usa.model.core.AbstractEntity;
import pl.usa.model.core.IEntity;
import pl.usa.model.org.CharacterPersonalNote;

@Data
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@Entity
@Table(name="characters")
public class Character extends AbstractEntity implements IEntity {

	@OneToOne(fetch=EAGER)
	@JoinColumn(name="user_id")
	@ForeignKey(name="user_to_character")
	@Index(name="user_character_idx")
	private User user;

	private String name;

	private int age;

	private String story;

	@OneToMany(fetch = EAGER, mappedBy = "character")
	private List<CharacterPersonalNote> notes;
}
