package com.example.repository.impl;

import com.example.repository.IDictionaryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DictionaryRepository implements IDictionaryRepository {

    static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("book", "sách");
        dictionary.put("phone", "điện thoại");
        dictionary.put("laptop", "máy tính");
        dictionary.put("shirt", "cái áo");
        dictionary.put("water", "nước");
    }

    @Override
    public String getDictionary(String eng) {
        return dictionary.get(eng);
    }
}
