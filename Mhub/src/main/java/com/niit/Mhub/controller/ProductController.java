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
import com.niit.Mhub.model.ProductModel;
import com.niit.Mhub.service.ProductService;


@Controller
public class ProductController {
	@Autowired
	ProductService ps;
	@Autowired
	SessionFactory sf;

	@Autowired
	private SessionFactory sessionFactory;
	
        // Products
		@RequestMapping("/Products")
		public ModelAndView product() {

			return new ModelAndView("product", "command", new ProductModel());
		}

		@RequestMapping("/addproduct")
		public ModelAndView addcategory(@ModelAttribute("ProductModel") ProductModel pm) {
			System.out.println("in add Product");
			ps.insertProductModel(pm);
			ModelAndView mv = new ModelAndView("product", "command", new ProductModel());
			return mv;
		}
		// view Products

				@SuppressWarnings("unused")
				@RequestMapping("/viewproduct")
				public ModelAndView viewproducts() {
					List<ProductModel> arr = ps.getProductList();
					Gson gson = new Gson();
					String json = gson.toJson(arr);
					return new ModelAndView("productlist", "data", gson.toJson(arr));
				}
				//update and delete
				int a;
				@RequestMapping("/edit3/{ProductId}")
				public ModelAndView edit(@PathVariable("ProductId")int pid,HttpServletRequest req) 
				 {
					System.out.println("in controller1");
					a=pid;
					System.out.println("in controller2");
					ProductModel p=new ProductModel();			
					System.out.println("in controller3");
					Session s=sf.openSession();
					ProductModel p1=(ProductModel)s.get(ProductModel.class,a);
					System.out.println("haiiiiii");
					System.out.println("p1.getProductName()"+p1.getProductName());
					ModelAndView m1 = new ModelAndView("updatepage");HttpSession sess=req.getSession();
					sess.setAttribute("data1",p1);
					m1.addObject("command", p1);
					System.out.println(p1.getProductName());
					m1.addObject("data", p1);		 
					return m1;
					}
				
				@RequestMapping("edit3/updateproduct")
				public ModelAndView update(@ModelAttribute("abayas")ProductModel p) 
				 {
					ps.update(p);
					return new ModelAndView("redirect:/viewproduct");  
				 }
				//delete product
				@RequestMapping("/delete3/{ProductId}")
				 public ModelAndView delete(@PathVariable("ProductId")int id) 
				 {
					ps.remove(id);
					return new ModelAndView("redirect:/viewproduct");  
				 }
}