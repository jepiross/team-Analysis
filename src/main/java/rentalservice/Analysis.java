package rentalservice;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Analysis_table")
public class Analysis {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer qty;
    private String status;
    private Long rentalId;

    @PostPersist
    public void onPostPersist(){
        DeliveryAnalized deliveryAnalized = new DeliveryAnalized();
        BeanUtils.copyProperties(this, deliveryAnalized);
        deliveryAnalized.publishAfterCommit();


        DeliveryCancelAnalized deliveryCancelAnalized = new DeliveryCancelAnalized();
        BeanUtils.copyProperties(this, deliveryCancelAnalized);
        deliveryCancelAnalized.publishAfterCommit();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Long getRentalId() {
        return rentalId;
    }

    public void setRentalId(Long rentalId) {
        this.rentalId = rentalId;
    }




}
