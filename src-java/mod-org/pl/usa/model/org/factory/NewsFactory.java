package pl.usa.model.org.factory;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.usa.model.main.News;
import pl.usa.utils.core.WebUtil;

@Service
public class NewsFactory {

	@Autowired private WebUtil webUtil;


	public void prepareToPersist(News news) {

		news.setAuthor(webUtil.getLoggedUser().getEmail());
		news.setDateCreate(new Date());
	}
}
