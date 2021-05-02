package net.ontopsolutions.learngraphqlspringboot.domain;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class Client {
    private UUID id;
    private String firstName;
    private List<String> middleNames;
    private String lastName;
}
