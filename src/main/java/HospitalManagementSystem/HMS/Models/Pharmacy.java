package HospitalManagementSystem.HMS.Models;

import jakarta.persistence.*;

@Entity
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long p_id;

    @Column
    private String medicineName;

    @Column
    private String companyName;

    @Column
    private String dateOfManufacture;

    @Column
    private String dateOfExpiry;

    @Column
    private long quantity;

    @Column
    private double price;

    public long getP_id() {
        return p_id;
    }

    public void setP_id(long p_id) {
        this.p_id = p_id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        if (medicineName != null) {
            this.medicineName = medicineName;
        }
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        if (companyName != null) {
            this.companyName = companyName;
        }
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        if (dateOfManufacture != null) {
            this.dateOfManufacture = dateOfManufacture;
        }
    }

    public String getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(String dateOfExpiry) {
        if (dateOfExpiry != null) {
            this.dateOfExpiry = dateOfExpiry;
        }
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        if (quantity != 0) {
            this.quantity = quantity;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price != 0) {
            this.price = price;
        }
    }
}
