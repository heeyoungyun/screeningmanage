package skcc;

public class ReservationRegistered extends AbstractEvent {

    private Long resvid;
    private String screeningId;
    private String hospitalId;
    private String chkDate;
    private String custNm;
    private String status;

    public Long getResvid() {
        return resvid;
    }

    public void setResvid(Long resvid) {
        this.resvid = resvid;
    }

    public String getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(String screeningId) {
        this.screeningId = screeningId;
    }
    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }
    public String getChkDate() {
        return chkDate;
    }

    public void setChkDate(String chkDate) {
        this.chkDate = chkDate;
    }
    public String getCustNm() {
        return custNm;
    }

    public void setCustNm(String custNm) {
        this.custNm = custNm;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}