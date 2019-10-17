package com.nanoo.business.batch;

import com.nanoo.consumer.repository.TopoBookingRepository;
import lombok.Data;
import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author nanoo
 * @create 17/10/2019 - 17:13
 */
@Service
@Transactional
@Data
@EnableAsync
public class ScheduleTask {
    
    private static final Logger log = LoggerFactory.getLogger(ScheduleTask.class);
    
    private final TopoBookingRepository topoBookingRepository;
    
    @Autowired
    public ScheduleTask(TopoBookingRepository topoBookingRepository) {
        this.topoBookingRepository = topoBookingRepository;
    }
    
    /**
     * This method is executed every day at 6:00 am to delete expired topoBooking
     */
    @Scheduled(cron="0 0 6 * * ?")
    public void removeOldTopoBooking()
    {
        try {
            topoBookingRepository.deleteAllOldTopoBooking(new Date());
        }catch (HibernateException e){
            log.error(e.getMessage());
        }
    }

}
