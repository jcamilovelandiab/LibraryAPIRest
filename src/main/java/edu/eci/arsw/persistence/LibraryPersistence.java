package edu.eci.arsw.persistence;

import java.util.List;
import java.util.Set;

import edu.eci.arsw.entities.Book;
import edu.eci.arsw.entities.Library;

public interface LibraryPersistence {

	
	public Set<Library> getAllLibraries();
	
	public Library getLibraryById(Integer idlibrary) throws LibraryException;
	
	public List<Book> getBooksByLibrary(Integer idlibrary) throws LibraryException;
	
	public void deleteLibrary(Integer idlibrary) throws LibraryException;
	
	public void saveBookToLibrary(Book book,Integer idlibrary) throws LibraryException;
	
	public void saveLibrary(Library library) throws LibraryPersistenceException;
	
}
