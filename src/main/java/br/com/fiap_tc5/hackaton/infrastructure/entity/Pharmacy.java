package br.com.fiap_tc5.hackaton.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "pharmacy",
        indexes = {
                @Index(name = "idx_state_city_neighb", columnList = "state, city, neighborhood")
        })
public class Pharmacy {

    @Id
    @Column(name = "cnpj", length = 14, nullable = false)
    private String cnpj;

    private String name;

    private String address;

    private String state;

    private String city;

    private String neighborhood;

    @Column(name = "accreditation_date")
    private Date accreditationDate;

    @OneToMany(mappedBy = "pharmacyId", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<PharmacyMedicineStock> pharmacyMedicineStock;

}
