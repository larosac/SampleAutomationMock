package com.reply.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.reply.model.Replyer;

@RestController
@RequestMapping(value="replyerMock")
public class Controller {


	@GetMapping( produces="application/json")
	public ResponseEntity<Replyer> getReplyer()
	{


		Replyer r=new Replyer();
		r.setNome("Carlo");
		r.setCognome("La Rosa");
		List<String> listCompetenze = new ArrayList<>();
		listCompetenze.add("terraform");
		listCompetenze.add("spring");
		r.setCompetenze((ArrayList)listCompetenze);
	


		return new ResponseEntity<Replyer>(r,HttpStatus.OK);	

	}
	
	
	
	
}
