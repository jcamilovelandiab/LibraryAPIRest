package edu.eci.arsw.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.entities.Library;
import edu.eci.arsw.persistence.LibraryException;
import edu.eci.arsw.services.LibraryServices;

@RestController
public class LibraryAPIController {

	@Autowired
	LibraryServices libraryServices;
	
	@GetMapping("/libraries")
	public ResponseEntity<?> getAllLibraries(){
		try {
			return new ResponseEntity<>(libraryServices.getAllLibraries(), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			Logger.getLogger(LibraryAPIController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>("Error when querying the libraries",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/libraries/{idlibrary}")
	public ResponseEntity<?> getLibraryById(@PathVariable Integer idlibrary){
		try {
			return new ResponseEntity<>(libraryServices.getLibraryById(idlibrary), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			Logger.getLogger(LibraryAPIController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>("Error when querying the library by name",HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/libraries/{idlibrary}/books")
	public ResponseEntity<?> getAllLibraries(@PathVariable Integer idlibrary){
		try {
			return new ResponseEntity<>(libraryServices.getBooksByLibrary(idlibrary), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			Logger.getLogger(LibraryAPIController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>("Error when querying the books of "+idlibrary,HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/libraries/{idlibrary}")
	public ResponseEntity<?> deleteLibrary(@PathVariable Integer idlibrary) {
		try {
			libraryServices.deleteLibrary(idlibrary);
			return new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (Exception e) {
			Logger.getLogger(LibraryAPIController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>("Error, the library could not be deleted", HttpStatus.FORBIDDEN);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> postSaveLibrary(@RequestBody Library library) {
		try {
			libraryServices.saveLibrary(library);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			Logger.getLogger(LibraryAPIController.class.getName()).log(Level.SEVERE, null, e);
			return new ResponseEntity<>("Error, the library could not be save", HttpStatus.FORBIDDEN);
		}
	}
	
	
	
}
