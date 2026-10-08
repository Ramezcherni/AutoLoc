package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contrat")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contrat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;

    @NotNull
    private LocalDate dateSignature;

    @NotNull
    @Positive
    private BigDecimal montantTotal;

    private boolean valide;

    @OneToMany(mappedBy = "contrat", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Paiement> paiements = new HashSet<>();

    @OneToOne(mappedBy = "contrat", fetch = FetchType.LAZY)
    private Reservation reservation;

    public void addPaiement(Paiement paiement) {
        paiements.add(paiement);
        paiement.setContrat(this);
    }
}
