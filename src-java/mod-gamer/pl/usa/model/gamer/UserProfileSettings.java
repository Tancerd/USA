package pl.usa.model.gamer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class UserProfileSettings implements Serializable {

	private static final long serialVersionUID = -9027484672765314891L;

	@Column(name="show_name")
	private boolean showName;

	@Column(name="show_last_name")
	private boolean showLastName;

	@Column(name="show_nick")
	private boolean showNick;

	@Column(name="show_description")
	private boolean showDescription;

	@Column(name="show_phone_number")
	private boolean showPhoneNumber;

	@Column(name="show_url")
	private boolean showUrl;
}
