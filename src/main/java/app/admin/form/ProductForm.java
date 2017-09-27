package app.admin.form;


import javax.validation.constraints.NotNull;

/**
 * @author Samuel Butta
 */
public class ProductForm {

    private String title;

    private String perex;

    @NotNull
    private Double priceWithVat;

    @NotNull
    private Double priceWithoutVat;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerex() {
        return perex;
    }

    public void setPerex(String perex) {
        this.perex = perex;
    }

    public Double getPriceWithVat() {
        return priceWithVat;
    }

    public void setPriceWithVat(Double priceWithVat) {
        this.priceWithVat = priceWithVat;
    }

    public Double getPriceWithoutVat() {
        return priceWithoutVat;
    }

    public void setPriceWithoutVat(Double priceWithoutVat) {
        this.priceWithoutVat = priceWithoutVat;
    }

    @Override
    public String toString() {
        return "ProductForm{" +
                "title='" + title + '\'' +
                ", perex='" + perex + '\'' +
                ", priceWithVat=" + priceWithVat +
                ", priceWithoutVat=" + priceWithoutVat +
                '}';
    }
}
