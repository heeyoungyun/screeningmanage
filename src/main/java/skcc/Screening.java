package skcc;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Table(name="Screening_table")
public class Screening {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String screeningId;
    private String custNm;
    private String custTelNo;
    private String hospitalId;
    private String hospitalNm;
    private String chkDate;
    private String status;
    private Long resvid;

    @PostPersist
    public void onPostPersist(){
        Requested requested = new Requested();
        BeanUtils.copyProperties(this, requested);
        requested.publishAfterCommit();


    }

    @PostUpdate
    public void onPostUpdate(){
        ScreeningChanged screeningChanged = new ScreeningChanged();
        BeanUtils.copyProperties(this, screeningChanged);
        screeningChanged.publishAfterCommit();
    }

    @PostRemove
    public void onPostRemove(){
        Canceled canceled = new Canceled();
        BeanUtils.copyProperties(this, canceled);
        canceled.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        skcc.external.Reservation reservation = new skcc.external.Reservation();

        System.out.println("ERROR :" + canceled.getResvid());

        reservation.setChkDate(canceled.getChkDate());
        reservation.setHospitalId(canceled.getHospitalId());
        reservation.setCustNm(canceled.getCustNm());
        reservation.setScreeningId(canceled.getScreeningId());
        reservation.setStatus("Canceled");

        System.out.println(" Cancel Foreign Call " + canceled.toJson());

        // mappings goes here
        ScreeningManageApplication.applicationContext.getBean(skcc.external.ReservationService.class)
            .reservationCancel(canceled.getResvid(),reservation);

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(String screeningId) {
        this.screeningId = screeningId;
    }
    public String getCustNm() {
        return custNm;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }
    public String getCustTelNo() {
        return custTelNo;
    }

    public void setCustTelNo(String custTelNo) {
        this.custTelNo = custTelNo;
    }
    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }
    public String getHospitalNm() {
        return hospitalNm;
    }

    public void setHospitalNm(String hospitalNm) {
        this.hospitalNm = hospitalNm;
    }
    public String getChkDate() {
        return chkDate;
    }

    public void setChkDate(String chkDate) {
        this.chkDate = chkDate;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Long getResvid() {
        return resvid;
    }

    public void setResvid(Long resvid) {
        this.resvid = resvid;
    }


}
