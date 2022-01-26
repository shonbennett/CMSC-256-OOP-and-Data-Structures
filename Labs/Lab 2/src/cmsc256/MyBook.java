//Shon Bennett (completed lab alone)
//CMSC 256 Sect 001, Professor Duke
//MyBook.java - this java file is a class that is used to create MyBook objects. There are also accessors/mutators, and comparison methods to
//compare MyBook objects.
//Created Jan 25 2021

package cmsc256;

public class MyBook implements Comparable<MyBook> {

    //instance variables (private data)
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private String ISBN10;
    private String ISBN13;

    //default constructor
    public MyBook(){
        title = "None Given";
        authorFirstName = "None Given";
        authorLastName = "None Given";
        ISBN10 = "0000000000";
        ISBN13 = "0000000000000";
    }

    //parameterized constructor
    public MyBook(String title, String authorFirstName, String authorLastName, String ISBN10, String ISBN13) {
        //initializes private data with setter methods to ensure input meets requirements
        setTitle(title);
        setAuthorFirstName(authorFirstName);
        setAuthorLastName(authorLastName);
        setISBN10(ISBN10);
        setISBN13(ISBN13);
    }

    //ACCESSOR AND MUTATOR METHODS
    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) throws IllegalArgumentException {
        if (newTitle != null) {
            this.title = newTitle;
        } else {
            throw new IllegalArgumentException("Arguments cannot be null!");
        }
    }

    public String getAuthorFirstName(){
        return authorFirstName;
    }

    public void setAuthorFirstName(String newAuthorFirstName) throws IllegalArgumentException {
        if (newAuthorFirstName != null) {
            this.authorFirstName = newAuthorFirstName;
        } else {
            throw new IllegalArgumentException("Arguments cannot be null!");
        }
    }

    public String getAuthorLastName(){
        return authorLastName;
    }

    public void setAuthorLastName(String newAuthorLastName) throws IllegalArgumentException {
        if (newAuthorLastName != null) {
            this.authorLastName = newAuthorLastName;
        } else {
            throw new IllegalArgumentException("Arguments cannot be null!");
        }
    }

    public String getISBN10() {
        return ISBN10;
    }

    public void setISBN10(String newISBN10) throws IllegalArgumentException {
        //first we check to make sure the input is not null
        if (newISBN10 == null) {
            throw new IllegalArgumentException("Arguments cannot be null!");
        }

        //check if characters are in the String
        if (checkForChars(newISBN10) == false) {
            throw new IllegalArgumentException("Cannot have characters in ISBN number!");
        }

        //make sure length is 10
        if ((newISBN10.length() == 10) == false) {
            throw new IllegalArgumentException("ISBN10 length must be 10!");
        } else {
            this.ISBN10 = newISBN10;
        }
    }

    public String getISBN13() {
        return ISBN13;
    }

    public void setISBN13(String newISBN13) {
        //first we check to make sure the input is not null
        if (newISBN13 == null) {
            throw new IllegalArgumentException("Arguments cannot be null!");
        }

        //check if characters are in the String
        if (checkForChars(newISBN13) == false) {
            throw new IllegalArgumentException("Cannot have characters in ISBN number!");
        }

        //make sure length is 13
        if ((newISBN13.length() == 13) == false) {
            throw new IllegalArgumentException("ISBN13 length must be 13!");
        } else {
            this.ISBN13 = newISBN13;
        }
    }

    @Override
    public String toString(){
        String returnString = "Title: " + getTitle() + "\n" + "Author: " + getAuthorFirstName() + " " + getAuthorLastName() + "\n" + "ISBN10: " + getISBN10() + "\n" + "ISBN13: " + getISBN13();

        return returnString;
    }

    @Override
    public boolean equals(Object otherBook) {
        //casting a String to the MyBook class would not work, so we are going to immediately end the method if a String is passed in
        if (otherBook instanceof String){
            return false;
        }
        //makes a MyBook Object out of otherBook var
        MyBook other = (MyBook) otherBook;
        //checks if this is a reference to itself
        if (this == other) {
            return true;
        }

        //will return false if otherBook is not instance of MyBook class
        if (other instanceof MyBook == false) {
            return false;
        }

        //compare ISBN numbers to see if they are the same ---> we use the equals method of the String class to compare ISBN numbers
        if ((this.ISBN13.equals(other.getISBN13()) == true) && (this.ISBN10.equals(other.getISBN10()) == true)) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param other
     * @return numericalResult
     *
     * Override of compareTo method tests to see if two book objects are the same, or if the other book comes before or after the MyBook
     * object, other, it is being compared to.
     *
     * use numericalResult var to store results of comparisons using compareTo method of String class
     * can only proceed to next test if the previous test was zero. at the end of the method, if zero is returned it means
     * the two books are equivalent. if neg, the other MyBook comes before the MyBook object that called it. if pos, the other MyBook comes
     * after the MyBook that called the method
     *
     * we compare the author last name, author first name and title in this method
     */
    @Override
    public int compareTo(MyBook other) {

        int numericalResult = this.authorLastName.compareTo(other.getAuthorLastName());

        if (numericalResult == 0) {
            numericalResult = this.authorFirstName.compareTo(other.getAuthorFirstName());
        }

        if (numericalResult == 0) {
            numericalResult = this.title.compareTo(other.getTitle());
        }

        return numericalResult;
    }



    /**
     *
     * @param isbnNum
     * @return
     *
     * extra method used to check if there are characters in the ISBN number
     *
     * if a character is present in the String, false is returned
     *
     * this method is called in setISBN10() and setISBN13() methods
     */
    public boolean checkForChars(String isbnNum){
        for (int i = 0; i < isbnNum.length(); i++) {
            if ((Character.isDigit(isbnNum.charAt(i))) == false) {
                return false;
            }
        }
        return true;
    }


}
