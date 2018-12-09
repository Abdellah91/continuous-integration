package com.demo.rater;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.data.RateData;
import com.demo.utils.StatisticsVote;

import java.util.Vector;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
@RestController
public class Thanks {
	private static Logger logger = LogManager.getLogger(Thanks.class);
	
	@RequestMapping(value="/thanks",method= {RequestMethod.POST,RequestMethod.GET},consumes = MediaType.APPLICATION_JSON_VALUE)
	   public  void  getSearchUserProfiles(@RequestBody RateData data, HttpServletRequest request) {
		synchronized (request) {
			double value=data.getValue();
			StatisticsVote.rates.add(value);
			StatisticsVote.sum=StatisticsVote.sum+value;	
			logger.info(StatisticsVote.rate());	
		}
		
	   }

}
