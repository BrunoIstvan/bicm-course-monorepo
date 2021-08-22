package br.com.bicmsystems.bicmpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentModel implements Serializable {

    private String name;
    private Double dailyIncome;
    private Integer days;

    public Double getTotal() {
        if(Objects.nonNull(dailyIncome) && Objects.nonNull(days)) {
            return dailyIncome * days;
        }
        return 0.0;
    }

}
