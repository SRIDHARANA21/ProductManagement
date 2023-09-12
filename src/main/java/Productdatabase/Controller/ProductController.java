package Productdatabase.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Productdatabase.Dao.Dao;
import Productdatabase.Dto.Product;
@Controller
public class ProductController {

	
	@Autowired
	Dao dao;
	
	@RequestMapping("/addproduct")
	public ModelAndView addproduct()
	{
		ModelAndView view =new ModelAndView();
		view.setViewName("addproduct.jsp");
		view.addObject("product",new Product());
		return view;
	}
	
	@RequestMapping("/saveproduct")
	public ModelAndView saveproduct(@ModelAttribute Product p)
	{		
		dao.saveproduct(p);
		List<Product> products=dao.displayall();
		ModelAndView view =new ModelAndView();
		view.setViewName("display.jsp");
		view.addObject("products",products);
		return view;
	}
	@RequestMapping("/display")
	public ModelAndView displayall()
	{
		ModelAndView view=new ModelAndView();
		List<Product> products=dao.displayall();
		view.setViewName("display.jsp");
		view.addObject("products", products);
		return view;
	}
	
	
	@RequestMapping("/delete")
	public ModelAndView deleteproduct(@RequestParam int id)
	{
		dao.deleteproduct(id);
		ModelAndView view=displayall();
		return view;
		
	}
	
	@RequestMapping("/edit")
	public ModelAndView editproduct(@RequestParam int id)
	{
		   Product exis=dao.findproduct(id);
		ModelAndView view=new ModelAndView();
		view.setViewName("edit.jsp");
		view.addObject("product",exis);
		return view;
	}
	
	@RequestMapping("/updateproduct")
	public ModelAndView updateproduct(@ModelAttribute Product p)
	{
		dao.updateproduct(p, p.getPid());
		ModelAndView view =displayall();
		return view;
	}

}

