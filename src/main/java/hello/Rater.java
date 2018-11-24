package hello;

import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.utils.StatisticsVote;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class Rater {
	private static Logger logger = LogManager.getLogger(Rater.class);
	@Value("${prez.url.thanks}")
	private String  hostName;
    @RequestMapping("/stars")
    public String rateView(Model model) {
		model.addAttribute("hostName", hostName);
		logger.info(hostName);	
        return "Stars";
    }

}
