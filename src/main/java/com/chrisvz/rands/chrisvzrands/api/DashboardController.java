package com.chrisvz.rands.chrisvzrands.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chrisvz.rands.chrisvzrands.repositories.MessageRepository;
import com.chrisvz.rands.chrisvzrands.repositories.UserAddListRepositery;
import com.chrisvz.rands.chrisvzrands.services.DashboardService;
import com.chrisvz.rands.chrisvzrands.vo.CustomeResponse;
import com.chrisvz.rands.chrisvzrands.vo.Message;
import com.chrisvz.rands.chrisvzrands.vo.User;
import com.chrisvz.rands.chrisvzrands.vo.UserAdd;




@RestController
@RequestMapping("users")
@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
public class DashboardController {

	@Autowired
	DashboardService dashboardService;

	@Autowired
	UserAddListRepositery userAddRepository;

	  @Autowired
	  MessageRepository messagedRepository;

//	@GetMapping("/getUserList")
	@RequestMapping(value = "/getUserList")
	public @ResponseBody CustomeResponse getme(@RequestParam(value = "id", required = false) Integer id) {

		System.out.println("in get message--->"+id);	
		
		//List l=dashboardService.getUserList(id);

		//For Jpa
	    List l= userAddRepository.findByIdCust(id);
	    System.out.println("in user list tutorialData ----->"+l);
		  

		
		
		//System.out.println("in list l--->"+l);
			
		CustomeResponse  vo =new CustomeResponse ();
		vo.setCode(200);
		vo.setData(l);
		vo.setMessage("success");
		return vo;
	}
	
	@PostMapping("/addToUserList")
	public @ResponseBody CustomeResponse addToUserList(@RequestBody UserAdd  ua) {
		
		
		System.out.println("in message"+ua.toString());
		
		//int i=dashboardService.addToUserList(ua.getUserID(),ua.getListID(),ua.getName());
	
		//List l=dashboardService.getUserList(ua.getUserID());
	    userAddRepository.save(ua);
	    List l= userAddRepository.findByIdCust(ua.getUserID());
		
		CustomeResponse  vo =new CustomeResponse ();
		vo.setCode(200);
		vo.setData(l);
		vo.setMessage("success");
		return vo;
	}


	@GetMapping("/getUserMessages")
	public @ResponseBody CustomeResponse getMeassages(@RequestParam int from ,@RequestParam int to ) {
		
		
		System.out.println("in get message--->"+from+"---"+to);

		List l1=dashboardService.getUserMeassageList(from,to);
		
		System.out.println("l1--->"+l1);
		
		
		//List l=dashboardService.getUserMeassageList(a,b);
		List<Message> l=messagedRepository.getList(from,to);
		//List<Message> l2=messagedRepository.getList2(from,to);
		//var cities = (List<City>) 
		//System.out.println("l--->"+l);
		//System.out.println("l2--->"+l2);
		
		for (Iterator iterator = l.iterator(); iterator.hasNext();) {
			Message o= (Message) iterator.next();
			//System.out.println("o--->"+o);
			
			if(o.getFromMsg()==from) {
				o.setUserMsg(true);
			}
			
		}
		
		System.out.println("message list--->"+l);

		
		CustomeResponse  vo =new CustomeResponse ();
		vo.setCode(200);
		vo.setData(l);
		vo.setMessage("success");
		return vo;
	}
	@PostMapping("/SendMsg")
	public @ResponseBody CustomeResponse SendMsg(@RequestBody Message m ) {
		
		System.out.println("in send--->"+m);
		
		messagedRepository.save(m);
		//List l=dashboardService.getUserMeassageList(m.getTo(),m.getFrom());
		List<Message> l=messagedRepository.getList(m.getToMsg(),m.getFromMsg());
			
		System.out.println("in message");
		CustomeResponse  vo =new CustomeResponse ();
		vo.setCode(200);
		vo.setData(l);
		vo.setMessage("success");
		return vo;
	}
	
	/*
	 * @GetMapping("/getUserMessages") public @ResponseBody CustomeResponse
	 * loginData() {
	 * 
	 * 
	 * System.out.println("in get message--->");
	 * 
	 * List l=dashboardService.getLOginData(); //List
	 * l=dashboardService.getUserMeassageList(a,b);
	 * 
	 * 
	 * CustomeResponse vo =new CustomeResponse (); vo.setCode(200); vo.setData(l);
	 * vo.setMessage("success"); return vo; }
	 */


}
