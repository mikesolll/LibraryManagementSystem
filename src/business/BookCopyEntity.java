package business;

import java.io.Serializable;

public class BookCopyEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5616939060914734040L;
	private String copyNo;
    private boolean availablity;
    private String  ISBN;

    BookCopyEntity(String copyNo, String ISBN,boolean availablity) {

        this.copyNo = copyNo;
        this.ISBN = ISBN;
        this.availablity=availablity;
    }

    public String getCopyNo() {
        return copyNo;
    }

    public void setCopyNo(String copyNo) {
        this.copyNo = copyNo;
    }

    public boolean isAvailablity() {
        return availablity;
    }

    public void setAvailablity(boolean availablity) {
        this.availablity = availablity;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
}
