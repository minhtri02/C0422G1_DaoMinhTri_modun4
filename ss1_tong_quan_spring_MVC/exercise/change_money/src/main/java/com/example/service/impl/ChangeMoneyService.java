package com.example.service.impl;

import com.example.service.IChangeMoneyService;
import org.springframework.stereotype.Service;

@Service
public class ChangeMoneyService implements IChangeMoneyService {

    @Override
    public Double changeMoney(String usd) {
        try{
            return Double.parseDouble(usd)*23000;
        }catch (NumberFormatException e){
            return 0.0;
        }

    }
}
