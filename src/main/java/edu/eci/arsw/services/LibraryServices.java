package edu.eci.arsw.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.eci.arsw.entities.Book;
import edu.eci.arsw.entities.Library;
import edu.eci.arsw.persistence.LibraryException;
import edu.eci.arsw.persistence.LibraryPersistence;
import edu.eci.arsw.persistence.LibraryPersistenceException;

@Service
public class LibraryServices {

	@Autowired
	@Qualifier("inMemoryLibraryPersistence")
	LibraryPersistence lps;
	
	public Set<Library> getAllLibraries(){
		return lps.getAllLibraries();
	}
	
	public void saveLibrary(Library library) throws LibraryPersistenceException {
		lps.saveLibrary(library);
	}
	
	public void saveBookToLibrary(Book book, Integer idlibrary) {
		try {
			lps.saveBookToLibrary(book, idlibrary);
		} catch (LibraryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Library getLibraryById(Integer idlibrary) throws LibraryException {
		return lps.getLibraryById(idlibrary);
	}
	
	public List<Book> getBooksByLibrary(Integer idlibrary) throws LibraryException{
		return lps.getBooksByLibrary(idlibrary);
	}
	
	public void deleteLibrary(Integer idlibrary) throws LibraryException  {
		lps.deleteLibrary(idlibrary);
	}
	
}
