package skcc;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ScreeningRepository extends PagingAndSortingRepository<Screening, Long>{

    List<Screening> findByHospitalIdAndChkDate(String HospitalId, String ChkDate);
    Screening findByScreeningId(String ScreeningId);
}