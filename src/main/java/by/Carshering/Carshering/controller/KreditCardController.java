package by.Carshering.Carshering.controller;

import by.Carshering.Carshering.service.KreditCardServiceImpl;
import by.Carshering.Carshering.service.api.KreditCardService;
import by.Carshering.Carshering.utils.dto.KreditCardDto;
import by.Carshering.Carshering.utils.dto.PayDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kreditCard")
@RequiredArgsConstructor
public class KreditCardController {
    private final KreditCardService kreditCardService;

    @GetMapping("/{cardNumber}")
    public KreditCardDto getByCardNumber(@PathVariable String cardNumber){
        return kreditCardService.getByCardNumber(cardNumber);
    }

    @PostMapping
    public void addMoney(PayDto payDto){
        kreditCardService.addMoney(payDto);
    }

}
