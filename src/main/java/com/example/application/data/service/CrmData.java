package com.example.application.data.service;

import com.example.application.data.entity.Company;
import com.example.application.data.entity.Contact;
import com.example.application.data.entity.Status;

import java.util.ArrayList;
import java.util.List;

public class CrmData {
    private List<Contact> contacts = new ArrayList<>();
    private List<Company> companies = new ArrayList<>();
    private List<Status> statuses = new ArrayList<>();

    public CrmData() {
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public List<Status> getStatuses() {
        return statuses;
    }
}
