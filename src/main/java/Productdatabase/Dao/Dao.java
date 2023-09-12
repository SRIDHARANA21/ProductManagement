package Productdatabase.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Productdatabase.Dto.Product;
@Component
public class Dao {
	
	@Autowired
	EntityManager em;

	public void saveproduct(Product p) {
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	public Product findproduct(int id)
	{
		Product  exitproduct=em.find(Product.class, id);
		if(exitproduct!=null)
		{
			return exitproduct;
		}
		else
		{
			return null;
		}
	}
	public void deleteproduct(int id)
	{
		Product remove=findproduct(id);
		if(remove!=null)
		{
			em.getTransaction().begin();
			em.remove(remove);
			em.getTransaction().commit();
		}
		
	}
  public List<Product> displayall()
  {
	  Query query=em.createQuery("select p from Product p ");
	  @SuppressWarnings("unchecked")
      List<Product>products=query.getResultList();
	  return products;
  }
  
  public Product updateproduct(Product pr,int id)
  {
	  Product exit=findproduct(id);
	  if(exit!=null)
	  {
		  exit.setPid(id);
		  em.getTransaction().begin();
		  em.merge(pr);
		  em.getTransaction().commit();
	      return exit;
	  }
	  else
	  {
		  return null;
	  }
  }

}
