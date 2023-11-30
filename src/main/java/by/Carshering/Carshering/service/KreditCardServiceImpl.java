package by.Carshering.Carshering.service;

import by.Carshering.Carshering.entity.KreditCard;
import by.Carshering.Carshering.repository.KreditCardRepository;
import by.Carshering.Carshering.service.api.KreditCardService;
import by.Carshering.Carshering.utils.dto.KreditCardDto;
import by.Carshering.Carshering.utils.dto.PayDto;
import by.Carshering.Carshering.utils.dto.convertor.KreditCardDtoConvertor;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KreditCardServiceImpl implements KreditCardService {
    private final KreditCardRepository kreditCardRepository;
    @Override
    public KreditCardDto getByCardNumber(String cardNumber) {
        return KreditCardDtoConvertor.convertEntityToDto(kreditCardRepository.findByCardNumber(cardNumber));
    }

    @Override
    @Transactional
    public void pay(PayDto payDto) throws Exception {
        KreditCard kreditCard = kreditCardRepository.findByCardNumber(payDto.getCardNumber());

        if (kreditCard.getCash()>=payDto.getCash()) {
            kreditCard.setCash(kreditCard.getCash() - payDto.getCash());
            kreditCardRepository.save(kreditCard);
        }
        else{
            throw new Exception("Error 901");
        }

    }

    @Override
    @Transactional
    public void addMoney(PayDto payDto) {
        KreditCard kreditCard = kreditCardRepository.findByCardNumber(payDto.getCardNumber());

        kreditCard.setCash(kreditCard.getCash()+payDto.getCash());

        kreditCardRepository.save(kreditCard);
    }
}
