
package Entities;

/**
 *
 * @author Admin
 */
public class Books {
    private String bcode;
    private String title;
    private int quantity;
    private int lended;
    private Double price;
    private int pages;
    public Books(String bcode, String title, int quantity, int lended, Double price, int pages) {
        this.bcode = bcode;
        this.title = title;
        this.quantity = quantity;
        this.lended = lended;
        this.price = price;
        this.pages=pages;
    }

    public String getBcode() {
        return bcode;
    }

    public void setBcode(String bcode) {
        this.bcode = bcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLended() {
        return lended;
    }

    public void setLended(int lended) {
        this.lended = lended;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
//
//    @Override
//    public String toString() {
//        return "Books{" + "bcode=" + bcode + ", title=" + title + ", quantity=" + quantity + ", lended=" + lended + ", price=" + price + '}';
//    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    

    
    
}
