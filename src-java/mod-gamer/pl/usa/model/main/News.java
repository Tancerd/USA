package pl.usa.model.main;

import static javax.persistence.EnumType.STRING;
import static pl.usa.model.main.NewsType.ORGS;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pl.usa.model.core.AbstractEntity;
import pl.usa.model.core.IEntity;

@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "news")
public class News extends AbstractEntity implements IEntity {

	private static final long serialVersionUID = -6621036716735783492L;

	@Column(nullable = false)
	private String title = "";

	@Column(name = "create_date", nullable = false)
	private Date dateCreate;

	private String content = "";

	@Column(nullable = false)
	private String author = "";

	@Column(nullable = false)
	@Enumerated(STRING)
	private NewsType type = ORGS;

}
