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
import com.niit.Mhub.model.CategoryModel;
import com.niit.Mhub.model.SupplierModel;
import com.niit.Mhub.service.CategoryService;


@Controller
public class CategoryController {

	@Autowired
	CategoryService cs;
	@Autowired
	SessionFactory sf;
	// Category
		@RequestMapping("/categories")
		public ModelAndView category() {

			return new ModelAndView("category", "command", new CategoryModel());
		}
		

		@RequestMapping("/addcategory")
		public ModelAndView addcategory(@ModelAttribute("CategoryModel") CategoryModel cm) {
			System.out.println("in add Category");
			cs.insertCategoryModel(cm);
			ModelAndView mv = new ModelAndView("category", "command", new CategoryModel());
			return mv;
		}
		
		//viewSuppliers
		@SuppressWarnings("unused")
		@RequestMapping("/viewcategory")
		public ModelAndView viewsupplier()
		{
			List <CategoryModel> arr= cs.getCategoryList();
			Gson gson=new Gson();
			String json=gson.toJson(arr);
			return new ModelAndView("categoryList","data",gson.toJson(arr));
		}
		//category
		
		int a;
		@RequestMapping("edit1/{categoryid}")
		public ModelAndView edit1(@PathVariable("categoryid")int cid,HttpServletRequest req) 
		 {
			System.out.println("in controller1");
			a=cid;
			System.out.println("in controller2");
			CategoryModel c=new CategoryModel();			
			System.out.println("in controller3");
			Session s=sf.openSession();
			CategoryModel c1=(CategoryModel)s.get(CategoryModel.class,a);
			System.out.println("haiiiiii");
			System.out.println("c1.getCategoryname()"+c1.getCategoryName());
			ModelAndView m1 = new ModelAndView("updatecategory");HttpSession sess=req.getSession();
			sess.setAttribute("data1",c1);
			m1.addObject("command", c1);
			System.out.println(c1.getCategoryName());
			m1.addObject("data", c1);		 
			return m1;
			}
		
		@RequestMapping("edit1/updatecategory")
		public ModelAndView update(@ModelAttribute("abayas")CategoryModel a) 
		 {
			cs.update(a);
			return new ModelAndView("redirect:/viewcategory");  
		 }
		//delete category
		@RequestMapping("delete1/{categoryid}")
		 public ModelAndView delete1(@PathVariable("categoryid")int id) 
		 {
			cs.remove(id);
			return new ModelAndView("redirect:/viewcategory");  
		 }
	
}
