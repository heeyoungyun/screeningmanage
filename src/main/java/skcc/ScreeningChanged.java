package skcc;

public class ScreeningChanged extends AbstractEvent {

    private Long id;
    private String screeningId;
    private String custNm;
    private String custTelNo;
    private String hospitalId;
    private String hospitalNm;
    private String chkDate;
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCheckupId() {
        return screeningId;
    }

    public void setCheckupId(String screeningId) {
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
}