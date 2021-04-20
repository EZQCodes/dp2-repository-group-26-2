package acme.entities.tasks;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task extends DomainEntity {
	
	// Serialisation identifier -----------------------------------------------
	
	protected static final long serialVersionUID = 1L;
	
	// Attributes -------------------------------------------------------------
	
	@NotBlank
	@Length(min=1, max=80)
	protected String title;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	@NotNull
	protected LocalDateTime executionPeriodInit;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Future
	@NotNull
	protected LocalDateTime executionPeriodEnd;
	
	@NotBlank
	@Length(min=1, max=500)
	protected String description;
	
	@URL
	protected String optionalLink;
	
	
	protected Boolean isPublic;
	
	// Derived attributes -----------------------------------------------------

	@Digits(fraction=2, integer=10)
	public Double workload(){
		final Long a = MINUTES.between(this.executionPeriodInit, this.executionPeriodEnd);
		return a.doubleValue()/60.0;
	}

}
