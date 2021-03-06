package nl.cimsolutions.snel_transport.models;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Product")
@Access(AccessType.FIELD)
public class Product {
	
	@TableGenerator(
            name = "ProductGenerator",
            allocationSize = 1,
            initialValue = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
            generator="ProductGenerator")
    @Column(name="id")
	private Long ProductId;
    @Column(name="Name")
	private String Name;
    @Column(name="Price")
	private Double Price;
    @Column(name="code")
	private String Code;
	@NotNull
	@Column(name="categoryid")
	private Long CategoryId;
//	@ManyToOne
//    @JoinColumn(name="CategoryId")
//    private Category Categories;
	
	public Product(){
		
	}
	
	public Product(Long productId, String name,String code, Double price, Long categoryId) {
		super();
		ProductId = productId;
		Name = name;
		Price = price;
		CategoryId = categoryId;
		Code = code;
	}
	
	public Long getProductId() {
		return ProductId;
	}
	public void setProductId(Long productId) {
		ProductId = productId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Double getPrice() {
		return Price;
	}
	public void setPrice(Double price) {
		Price = price;
	}
	public Long getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(Long categoryId) {
		CategoryId = categoryId;
	}
	@Override
    public int hashCode() {
        int hash = 0;
        hash += (ProductId != null ? ProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.ProductId == null && other.ProductId != null) || (this.ProductId != null && !this.ProductId.equals(other.ProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Product[ id=" + ProductId + " ]";
    }
	
}