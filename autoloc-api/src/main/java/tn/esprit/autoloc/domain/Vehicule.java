package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @Builder.Default
    private Set<Reservation> reservations = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vehicule_equipement",
        joinColumns = @JoinColumn(name = "id_vehicule"),
        inverseJoinColumns = @JoinColumn(name = "id_equipement"))
    @Builder.Default
    private Set<Equipement> equipements = new HashSet<>();
}
