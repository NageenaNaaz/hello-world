package com.niit.Mhub.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.Mhub.model.SupplierModel;
import com.niit.Mhub.service.SupplierService;

@Controller
public class SupplierController {
	@Autowired
	SupplierService ss;
	@Autowired
	SessionFactory sf;
	//supplier
	
			@RequestMapping("/suppliers")
			public ModelAndView supplier()
			{
				return new ModelAndView("supplier","command",new SupplierModel());
			}
			
			//addSupplier
			@RequestMapping("/addsupplier")
			public ModelAndView addsupplier(@ModelAttribute("SupplierModel")SupplierModel sm)
			{
				System.out.println("in add Supplier");
				ss.insertSupplierModel(sm);
				ModelAndView mv=new ModelAndView("supplier","command",new SupplierModel());
				return mv;
			}
			//viewSuppliers
			@SuppressWarnings("unused")
			@RequestMapping("/viewsupplier")
			public ModelAndView viewsupplier()
			{
				List <SupplierModel> arr= ss.getSupplierList();
				Gson gson=new Gson();
				String json=gson.toJson(arr);
				return new ModelAndView("supplierList","data",gson.toJson(arr));
			}
			//Supplier update or edit
			int s;
			@RequestMapping("edit2/{SupplierId}")
			public ModelAndView edit2(@PathVariable("SupplierId")int sid,HttpServletRequest req) 
			 {
				System.out.println("in controller1");
				s=sid;
				System.out.println("in controller2");
				SupplierModel c=new SupplierModel();			
				System.out.println("in controller3");
				Session s2=sf.openSession();
				SupplierModel s1=(SupplierModel)s2.get(SupplierModel.class,s);
				System.out.println("haiiiiii");
				System.out.println("c1.getSupplierName()"+s1.getSupplierName());
				ModelAndView m1 = new ModelAndView("updatesupplier");HttpSession sess=req.getSession();
				sess.setAttribute("data1",s1);
				m1.addObject("command", s1);
				System.out.println(s1.getSupplierName());
				m1.addObject("data", s1);		 
				return m1;
				}
			
			@RequestMapping("edit2/updatesupplier")
			public ModelAndView update(@ModelAttribute("abayas")SupplierModel s) 
			 {
				ss.update(s);
				return new ModelAndView("redirect:/viewsupplier");  
			 }
			//delete supplier
			@RequestMapping("delete2/{SupplierId}")
			 public ModelAndView delete2(@PathVariable("SupplierId")int id) 
			 {
				ss.remove(id);
				return new ModelAndView("redirect:/viewsupplier");  
			 }

}
