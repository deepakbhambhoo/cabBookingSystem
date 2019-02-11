package com.ola.controllers;   
import java.sql.SQLException;
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;    
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.ola.modal.Cab;
import com.ola.service.OlaService;  
@Controller  
public class CabController {  
    @Autowired  
    OlaService olaService;//will inject dao from xml file  
      
   /* It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form */
       
    @RequestMapping("/registrationCab")  
    public String showform(Model m){
    	System.out.println("test");
    	m.addAttribute("command", new Cab());
    	return "registrationCab"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cab") Cab cab){  
        //dao.save(emp);  
    	try {
			olaService.getCabDao().registerCab(cab);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "redirect:/viewCab";//will redirect to viewemp request mapping  
    } 
    
    @RequestMapping("/viewCab")  
	public String viewCab(Model m){  
	    List<Cab> list = null;
		try {
			list = olaService.getCabDao().getAllCab();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    m.addAttribute("list",list);
	    
	    return "viewCab";  
	
    } 
    
    @RequestMapping("/deleteCab")
    public String deleteCab(@ModelAttribute("cab") Cab cab){
    	olaService.unregisterCabDriver(cab);
    	return "redirect:/viewCab";
    }

}
   
	 
  /*  It provides list of employees in model object   
    @RequestMapping("/viewemp")  
    public String viewemp(Model m){  
        List<Emp> list=dao.getEmployees();  
        m.addAttribute("list",list);
        return "viewemp";  
    }  
   /*  It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.  
    @RequestMapping(value="/editemp/{id}")  
    public String edit(@PathVariable int id, Model m){  
        Emp emp=dao.getEmpById(id);  
        m.addAttribute("command",emp);
        return "empeditform";  
    }  
     It updates model object.   
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("emp") Emp emp){  
        dao.update(emp);  
        return "redirect:/viewemp";  
    }  
     It deletes record for the given id in URL and redirects to /viewemp   
    @RequestMapping(value="/deleteemp/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/viewemp";  
    }   */
 