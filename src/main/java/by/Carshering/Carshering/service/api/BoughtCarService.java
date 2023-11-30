package by.Carshering.Carshering.service.api;

import by.Carshering.Carshering.utils.dto.BoughtCarDto;

public interface BoughtCarService {
    BoughtCarDto findById(long id);
    void cancel(long accountId,long carId);
}
