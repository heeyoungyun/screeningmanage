
package skcc;

public class Deleted extends AbstractEvent {

    private Long id;
    private String hospitalId;
    private String hospitalNm;
    private String chkDate;
    private Long pCnt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public Long getPCnt() {
        return pCnt;
    }

    public void setPCnt(Long pCnt) {
        this.pCnt = pCnt;
    }
}
