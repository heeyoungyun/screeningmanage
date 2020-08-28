
package skcc.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="ReservationManage", url="http://localhost:8083")
public interface ReservationService {

    //@RequestMapping(method= RequestMethod.PUT, path="/reservations")
    //public void reservationCancel(@RequestBody Reservation reservation);


    @RequestMapping(method= RequestMethod.PUT, path="/reservations/{resvId}")
    public void reservationCancel(@PathVariable("resvId") Long id, @RequestBody Reservation reservation);

}