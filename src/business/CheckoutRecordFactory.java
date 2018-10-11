package business;

import java.time.LocalDate;

public class CheckoutRecordFactory {

    private CheckoutRecordFactory(){}

    public static CheckOutEntry createCheckoutRecord(String memberId, String bookId, LocalDate checkOutDate, LocalDate dueDate, String title){
            return new CheckOutEntry(memberId,bookId,checkOutDate,dueDate,title);
    }
}
