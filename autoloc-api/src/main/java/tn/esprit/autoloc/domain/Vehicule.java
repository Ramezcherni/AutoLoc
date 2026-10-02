package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "vehicule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;

    @NotBlank
    @Column(unique = true)
    private String immatriculation;

    @NotBlank
    private String marque;

    @NotBlank
    private String modele;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;

    @NotNull
    @Positive
    private BigDecimal tarifJournalier;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;
}
