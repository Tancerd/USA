package pl.usa.model.org;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.FetchType.EAGER;
import static pl.usa.model.org.BriefingStatus.NEW;
import static pl.usa.model.org.BriefingStatus.READY;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.Index;

import pl.usa.model.gamer.User;

@Data
@Embeddable
public class Briefing {

	@OneToOne(fetch=EAGER)
	@JoinColumn(name="game_master")
	@ForeignKey(name="user_to_briefing")
	@Index(name="user_briefing_idx")
	private User gameMaster;

	@Column(name = "briefing_status")
	@Enumerated(STRING)
	private BriefingStatus briefingStatus = NEW;

	private String fraction = "";

	private String know = "";

	private String have = "";

	private String want = "";

	private String gossip = "";

	private String description = "";

	public boolean isReady() {
		return briefingStatus == READY;
	}
}
