package com.example.service.impl;

import com.example.repository.IDictionaryRepository;
import com.example.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DictionaryService implements IDictionaryService {

    @Autowired
    private IDictionaryRepository iDictionaryRepository;

    @Override
    public String getDictionary(String eng) {
        String key = eng.toLowerCase();
        return this.iDictionaryRepository.getDictionary(key);
    }
}
