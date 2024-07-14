case class Book(title: String, author: String, isbn: String);

object LibraryManagementSystem {

  var library: Set[Book] = Set(
    Book("be You", "Geo nedwick", "978"),
    Book("To the Moon", "Harmen doily", "979"),
    Book("The Prince", "fansis holaman", "980")
  )

  //add a new book 
  def addBook(book: Book): Unit = {
    library += book;
    println(s"Book added: $book");
  }

  //remove a book
  def removeBookByISBN(isbn: String): Unit = {
    library.foreach { x => 
        if (x.isbn == isbn) library -= x;
    }
    println(s"Book with ISBN $isbn removed.");
  }

  //checking the availability
  def isBookInLibrary(isbn: String): Boolean = {
  var found = false;
  library.foreach { x => 
    if (x.isbn == isbn) found = true };
  found; 
 }

  //display the current library
  def displayLibrary(): Unit = {
    println("Current Library Collection:");
    library.foreach {x => 
        println(s"Title: ${x.title}, Author: ${x.author}, ISBN: ${x.isbn}")};
        
  }

  //search for a book
  def searchBookByTitle(title: String): Unit = {
    library.foreach { x => if (x.title == title) 
        println(s"Found Book - Title: ${x.title}, Author: ${x.author}, ISBN: ${x.isbn}")};
  }
   

  //display all books by a specific author
  def displayBooksByAuthor(author: String): Unit = {
    library.foreach { x => if (x.author == author)
        println(s"Title: ${x.title}, Author: ${x.author}, ISBN: ${x.isbn}")};
  }
}


  object main extends App {

    println();
    LibraryManagementSystem.displayLibrary();
    println();

    println("Adding a new book...");
    LibraryManagementSystem.addBook(Book("Brave New World", "Aldous Huxley", "981"));
    LibraryManagementSystem.displayLibrary();
    println();

    println("Removing a book...");
    LibraryManagementSystem.removeBookByISBN("978");
    LibraryManagementSystem.displayLibrary();
    println();

    println("Checking if a book with ISBN 979 is in the library...");
    var found = LibraryManagementSystem.isBookInLibrary("979")
    println(found);
    println();

    println("Searching for a book by title The Prince");
    LibraryManagementSystem.searchBookByTitle("The Prince");
    println();

    println("Displaying all books by author 'Aldous Huxley'...");
    LibraryManagementSystem.displayBooksByAuthor("Aldous Huxley");
    println();
    
  }


