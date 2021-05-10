package net.ontopsolutions.learngraphqlspringboot.domain;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class BankAccount {

    private UUID id;
    private  Client client;
    private Currency currency;
    private List<Asset> assets;
}
