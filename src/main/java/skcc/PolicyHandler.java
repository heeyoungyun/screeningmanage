package skcc;

import skcc.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyHandler{


    @Autowired
    ScreeningRepository screeningRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDeleted_ForcedCancel(@Payload Deleted deleted){

        if(deleted.isMe()){

            //  병원일정 삭제로 인한 , 스케쥴 상태 변경
            System.out.println("##### 검진 일정 삭제로 인한, 강제 취소 : " + deleted.toJson());

            //  Screening - Status ForceCancel
            List<Screening> list = screeningRepository.findByHospitalIdAndChkDate(deleted.getHospitalId(),deleted.getChkDate());

            for(Screening temp : list){
                temp.setStatus("ForcedCancel");
                screeningRepository.save(temp);
            }

        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverReservationRegistered_StatusUpdate(@Payload ReservationRegistered reservationRegistered){

        if(reservationRegistered.isMe()){

            System.out.println("################### reservationRegistered " + reservationRegistered.toJson());
            // 상태 값, 예약아이디를 변경 해준다
            Screening temp = screeningRepository.findByScreeningId(reservationRegistered.getScreeningId());
            temp.setResvid(reservationRegistered.getResvid());
            temp.setStatus(reservationRegistered.getStatus());
            screeningRepository.save(temp);

        }
    }

}
