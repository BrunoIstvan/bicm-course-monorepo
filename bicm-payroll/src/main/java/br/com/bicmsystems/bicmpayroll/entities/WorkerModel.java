package br.com.bicmsystems.bicmpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WorkerModel implements Serializable {

    private Long id;
    private String name;
    private Double dailyIncome;

}
