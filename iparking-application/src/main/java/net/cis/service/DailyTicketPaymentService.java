package net.cis.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import net.cis.dto.DailyTicketPaymentDto;
import net.cis.dto.DailyTicketPaymentEndPointDto;
import net.cis.jpa.criteria.DailyTicketPaymentCriteria;

public interface DailyTicketPaymentService {
    DailyTicketPaymentEndPointDto findAllFooter(DailyTicketPaymentCriteria ticketCriteria, Pageable pageable);

}
