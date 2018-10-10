package util;

public enum Storage {
    BOOK("book"),BOOKCOPY("bookCopy"),MEMBER("member"),USER("user");

    private  String val;
    private Storage(String val){
        this.val=val;
    }

    public String getVal() {
        return val;
    }
}
