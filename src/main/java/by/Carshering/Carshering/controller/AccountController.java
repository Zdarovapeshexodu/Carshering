package by.Carshering.Carshering.controller;

import by.Carshering.Carshering.entity.BoughtCar;
import by.Carshering.Carshering.service.api.AccountService;
import by.Carshering.Carshering.utils.dto.AccountDto;
import by.Carshering.Carshering.utils.dto.BoughtCarDto;
import by.Carshering.Carshering.utils.dto.CardCreationDto;
import by.Carshering.Carshering.utils.dto.RentCarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("/rent")
    public void rentCar(@RequestBody RentCarDto rentCarDto) throws Exception{
        accountService.rentCar(rentCarDto);
    }

    @GetMapping("/{name}")
    public AccountDto findByName(@PathVariable String name){
        return accountService.findByName(name);
    }

    @GetMapping("/all/{accountName}")
    public List<BoughtCarDto> getRentedCars(@PathVariable String accountName){
        return accountService.getRentedCars(accountName);
    }

    @PostMapping("/{id}")
    public void addCard(@PathVariable long id, @RequestBody CardCreationDto cardCreationDto){
        accountService.addCard(id,cardCreationDto);
    }

}
