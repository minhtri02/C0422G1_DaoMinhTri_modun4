package com.example.repository.impl;

import com.example.model.BoxEmail;
import com.example.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailRepository implements IEmailRepository {

    private static BoxEmail boxEmail = new BoxEmail("English","25",
            false,"King, Asgard");

    private static List<String> listLanguages = new ArrayList<>();

    private static List<String> listPageSize = new ArrayList<>();

    static {
        listPageSize.add("5");
        listPageSize.add("10");
        listPageSize.add("15");
        listPageSize.add("20");
        listPageSize.add("25");
        listPageSize.add("50");
        listPageSize.add("100");
    }

    static {
        listLanguages.add("English");
        listLanguages.add("Vietnamese");
        listLanguages.add("Japanese");
        listLanguages.add("Chinese");
    }

    @Override
    public List<String> languages() {
        return listLanguages;
    }

    @Override
    public List<String> pageSize() {
        return listPageSize;
    }

    @Override
    public BoxEmail displayEmail() {
        return boxEmail;
    }

    @Override
    public void updateEmail(BoxEmail box) {
        boxEmail.setLanguage(box.getLanguage());
        boxEmail.setPageSize(box.getPageSize());
        boxEmail.setSignature(box.getSignature());
        boxEmail.setSpamFilter(box.isSpamFilter());
    }
}
