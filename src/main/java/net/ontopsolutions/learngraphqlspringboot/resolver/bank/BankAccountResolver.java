package net.ontopsolutions.learngraphqlspringboot.resolver.bank;

import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import net.ontopsolutions.learngraphqlspringboot.domain.bank.BankAccount;
import net.ontopsolutions.learngraphqlspringboot.domain.bank.Currency;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id){
        log.info("Retrieving bank account id {}", id);
        return BankAccount.builder()
                .id(id)
                .currency(Currency.EUR)
                .build();
    }
}
