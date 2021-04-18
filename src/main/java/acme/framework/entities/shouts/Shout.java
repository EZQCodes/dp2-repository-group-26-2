package acme.framework.entities.shouts;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.URL;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter


public   class Shout {
		//Serialisation identifier --------------------------------
		protected static final long serialVersionUID = 1L;
		
		//Attributes
		@Temporal(TemporalType.TIMESTAMP)
		@Past
		@NotNull
		protected Date moment;
		@NotBlank
		protected String author;
		@NotBlank
		protected String text;
		@URL
		protected String info;
}
