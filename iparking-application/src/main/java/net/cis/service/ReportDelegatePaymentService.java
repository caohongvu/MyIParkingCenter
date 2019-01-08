package net.cis.service;

import java.util.List;

import net.cis.dto.ReportDelegatePaymentDto;

public interface ReportDelegatePaymentService {
	
    List<ReportDelegatePaymentDto> findByCarppIdsAndDate(Long[] carppIds, String date);

}
