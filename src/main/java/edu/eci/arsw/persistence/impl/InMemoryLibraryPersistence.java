package edu.eci.arsw.persistence.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import edu.eci.arsw.entities.Book;
import edu.eci.arsw.entities.Library;
import edu.eci.arsw.persistence.LibraryException;
import edu.eci.arsw.persistence.LibraryPersistence;
import edu.eci.arsw.persistence.LibraryPersistenceException;

@Component("inMemoryLibraryPersistence")
public class InMemoryLibraryPersistence implements LibraryPersistence {
	
	private final Map<Integer, Library> libraries = new HashMap<>();

	
	public InMemoryLibraryPersistence() {
		// load stub data
		// Library Juan
		List<Book> booksJuan = new ArrayList<Book>();
		booksJuan.add( new Book(001, "Harry potter", "Unknown", "Se trata de un man con gafas y que tiene una varita"));
		booksJuan.add( new Book(002, "Game of thronws", "olvido", "Guerra por obtener el trono"));
		Library juanLibrary = new Library(001, "La libreria de juan", "escuela eci", "+1(35) 3000545", booksJuan);

		
		List<Book> booksCamilo = new ArrayList<Book>();
		booksCamilo.add(new Book(003, "Capitana marvel", "Un man que escribio un comic", "Es una superhero"));
		booksCamilo.add( new Book(004, "El expreso de Budapest", "Unknown", "Un man que va en un tren"));
		Library camiloLibrary = new Library(002, "La libreria de camilo", "escuela eci", "30-564-656456", booksCamilo);
		

		Library noBooksLibrary = new Library(003, "La libreria de NOBOOKS", "arsw", "+57 3135-1556");
		
		libraries.put(juanLibrary.getId(), juanLibrary);
		libraries.put(camiloLibrary.getId(), camiloLibrary);
		libraries.put(noBooksLibrary.getId(), noBooksLibrary);
		
	}

	
	@Override
	public Library getLibraryById(Integer idlibrary) throws LibraryException {
		if(libraries.containsKey(idlibrary)) {
			return libraries.get(idlibrary);
		}else {
			throw new LibraryException("The library doesn't exists");
		}
	}

	@Override
	public List<Book> getBooksByLibrary(Integer idlibrary) throws LibraryException {
		if(libraries.containsKey(idlibrary)) {
			Library lib = libraries.get(idlibrary);
			return lib.getBooks();
		}else {
			throw new LibraryException("The library doesn't exists");
		}
	}

	@Override
	public void deleteLibrary(Integer idlibrary) throws LibraryException {
		if(libraries.containsKey(idlibrary)) {
			Library lib = libraries.get(idlibrary);
			if(lib.getBooks().size()>0) {
				throw new LibraryException("The library can not remove because it has books");
			}else {
				libraries.remove(idlibrary);
			}
		}else {
			throw new LibraryException("The library doesn't exists");
		}
	}

	@Override
	public void saveBookToLibrary(Book book,Integer idlibrary) throws LibraryException {
		if(libraries.containsKey(idlibrary)) {
			Library lib = libraries.get(idlibrary);
			List<Book> listBooks = lib.getBooks();
			listBooks.add(book);
			lib.setBooks(listBooks);
		}else {
			throw new LibraryException("The library doesn't exists");
		}	
	}

	@Override
	public Set<Library> getAllLibraries(){
		Set<Library> librariesAll = new HashSet<Library>();
		for(Map.Entry<Integer, Library> lib : libraries.entrySet()) {
			librariesAll.add(lib.getValue());
		}
		return librariesAll;
	}

	@Override
	public void saveLibrary(Library library) throws LibraryPersistenceException {
		if(libraries.containsKey(library.getId())) {
			throw new LibraryPersistenceException("Another library exists with the same name");
		}else {
			libraries.put(library.getId(), library);
		}
	}

}
