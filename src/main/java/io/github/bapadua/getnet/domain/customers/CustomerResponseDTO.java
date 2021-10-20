package io.github.bapadua.getnet.domain.customers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {
    private List<CustomerDTO> customers;
}
