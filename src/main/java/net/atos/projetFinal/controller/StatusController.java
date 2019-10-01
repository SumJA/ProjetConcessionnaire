package net.atos.projetFinal.controller;

import net.atos.projetFinal.model.Status;
import net.atos.projetFinal.service.impl.ServiceStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StatusController {
    
    @Autowired
    private ServiceStatus serviceStatus;
    
    @RequestMapping(value = "/Status", method = RequestMethod.GET)
    @ResponseBody
    List<Status> getAllStatus() {
        
        return serviceStatus.getAllStatuts();
        
    }

//	@RequestMapping(value = "/Status/{idStatus}", method = RequestMethod.GET)
//	@ResponseBody
//	Optional<Status> getStatusById(@PathVariable final int idStatus)
//	{
//		
//		
//		return this.serviceStatus.getDao().findById(idStatus);
//		
//		
//		
//	}
//	
//	
//	@RequestMapping(value = "/Status/{idStatus}", method = RequestMethod.DELETE)
//	@ResponseBody
//	ResponseEntity<Status> deleteStatusById(final int idStatus)
//	{
//		
//		this.serviceStatus.supprimerStatusById(idStatus);
//		return new ResponseEntity<Status>(HttpStatus.NO_CONTENT);
//		
//	}
    
    
    @RequestMapping(value = "/Status", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<Status> addStatus(@RequestBody Status status) {
        
        this.serviceStatus.getDao().save(status);
        
        return new ResponseEntity<Status>(HttpStatus.NO_CONTENT);
        
        
    }
    
    
    @RequestMapping(value = "/Status", method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<Status> updateStatus(@RequestBody Status status) {
        System.err.println("methode updateStatus: ");
        this.serviceStatus.getDao().save(status);
        return new ResponseEntity<Status>(HttpStatus.NO_CONTENT);
        
    }
    
    
}
