package co.shinetech.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

/**
 * Created by Marc on 09/08/2017.
 */

@Entity
@Table
public class SpecialOffer implements Domain<Long> {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDateTime offerStartDate;
    @Column
    private LocalDateTime offerEndDate;
    @Column
    private BigDecimal fixedPriceAmountOff;
    @Column
    private float percentageOff;
    @Column
    private Product productOnOffer;
    @Column
    private Category categoryOnOffer;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOfferStartDate() {
        return offerStartDate;
    }

    public void setOfferStartDate(LocalDateTime offerStartDate) {
        this.offerStartDate = offerStartDate;
    }

    public LocalDateTime getOfferEndDate() {
        return offerEndDate;
    }

    public void setOfferEndDate(LocalDateTime offerEndDate) {
        this.offerEndDate = offerEndDate;
    }

    public BigDecimal getFixedPriceAmountOff() {
        return fixedPriceAmountOff;
    }

    public void setFixedPriceAmountOff(BigDecimal fixedPriceAmountOff) {
        this.fixedPriceAmountOff = fixedPriceAmountOff.setScale(2, RoundingMode.CEILING);
    }

    public float getPercentageOff() {
        return percentageOff;
    }

    public void setPercentageOff(float percentageOff) {
        this.percentageOff = percentageOff;
    }

    public Product getProductOnOffer() {
        return productOnOffer;
    }

    public void setProductOnOffer(Product productOnOffer) {
        this.productOnOffer = productOnOffer;
    }

    public Category getCategoryOnOffer() {
        return categoryOnOffer;
    }

    public void setCategoryOnOffer(Category categoryOnOffer) {
        this.categoryOnOffer = categoryOnOffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpecialOffer that = (SpecialOffer) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return "SpecialOffer{" +
                "id=" + id +
                ", offerStartDate=" + offerStartDate +
                ", offerEndDate=" + offerEndDate +
                ", fixedPriceAmountOff=" + fixedPriceAmountOff +
                ", percentageOff=" + percentageOff +
                ", productOnOffer=" + productOnOffer +
                ", categoryOnOffer=" + categoryOnOffer +
                '}';
    }
}
