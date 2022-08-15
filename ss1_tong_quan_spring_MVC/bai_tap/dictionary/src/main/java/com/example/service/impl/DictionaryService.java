package com.example.service.impl;

import com.example.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    static Map<String , String> dictionary = new HashMap<>();
    static {
        dictionary.put("book","sách");
        dictionary.put("phone","điện thoại");
        dictionary.put("laptop","máy tính");
        dictionary.put("shirt","cái áo");
        dictionary.put("warter","nước");
    }


    @Override
    public String getDictionary(String eng) {
        String key = eng.toLowerCase();
        return dictionary.get(key);
    }
}
