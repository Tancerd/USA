package pl.usa.model.org;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.usa.model.core.AbstractEntity;
import pl.usa.model.core.IEntity;

@Data
@EqualsAndHashCode(of="id")
@Entity
@Table(name="briefing_tags")
public class BriefingTag  extends AbstractEntity implements IEntity {

	private static final long serialVersionUID = -1544102815507526938L;

	@Column(unique = true, nullable = false)
	private String identifier = "";

	@Column(nullable = false)
	private String description = "";

	@Column(nullable = false)
	private String text = "";

}
