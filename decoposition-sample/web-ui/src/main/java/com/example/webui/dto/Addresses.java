package com.example.webui.dto;

import lombok.Data;

import java.util.List;

@Data
public class Addresses {

    private List<AddressDto> addresses;
    public Addresses(List<AddressDto > addresses) {
        this.addresses = addresses;
    }

    public Addresses() {
    }
}
