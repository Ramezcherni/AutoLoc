package tn.esprit.autoloc.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    @NotBlank
    private String nom;

    @NotBlank
    private String prenom;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    private String telephone;

    @NotBlank
    @Column(unique = true)
    private String numPermis;

    @NotNull
    private LocalDate dateInscription;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Builder.Default
    private Set<Reservation> reservations = new HashSet<>();
}
