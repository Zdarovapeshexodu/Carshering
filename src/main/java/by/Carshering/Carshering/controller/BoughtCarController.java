package by.Carshering.Carshering.controller;

import by.Carshering.Carshering.service.api.BoughtCarService;
import by.Carshering.Carshering.utils.dto.BoughtCarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/boughtCars")
@RequiredArgsConstructor
public class BoughtCarController {
    private final BoughtCarService boughtCarService;

    @GetMapping("/{id}")
    public BoughtCarDto findById(@PathVariable long id){
        return boughtCarService.findById(id);
    }

    @PostMapping("/{accountId}/[carId]")
    public void cancel(@PathVariable long accountId, @PathVariable long carId){
        boughtCarService.cancel(accountId, carId);
    }
}
