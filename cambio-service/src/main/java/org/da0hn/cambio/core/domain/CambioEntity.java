package org.da0hn.cambio.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cambio")
public class CambioEntity implements Serializable {

  @Serial private static final long serialVersionUID = 2134541813091915L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "from_currency", length = 3, nullable = false)
  private String from;
  @Column(name = "to_currency", length = 3, nullable = false)
  private String to;
  @Column(nullable = false)
  private BigDecimal conversionFactor;

}
