package net.ontopsolutions.learngraphqlspringboot.domain;

import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Asset {

    UUID id;
}
