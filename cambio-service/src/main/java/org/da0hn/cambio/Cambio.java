package org.da0hn.cambio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cambio implements Serializable {

  @Serial private static final long serialVersionUID = 7923323386406933634L;

  private Long id;
  private String from;
  private String to;
  private BigDecimal conversionFactor;
  private BigDecimal convertedValue;
  private String environment;

}
