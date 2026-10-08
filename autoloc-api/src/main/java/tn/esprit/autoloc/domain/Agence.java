package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "agence")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Agence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgence;

    @NotBlank
    private String nom;

    @NotBlank
    private String ville;

    @NotBlank
    private String adresse;

    @NotBlank
    private String telephone;

    @OneToMany(mappedBy = "agence", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @Builder.Default
    private Set<Vehicule> vehicules = new HashSet<>();

    @OneToMany(mappedBy = "agence", fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Employe> employes = new HashSet<>();
}
