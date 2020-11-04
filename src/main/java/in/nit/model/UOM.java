package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.sun.xml.internal.ws.developer.StreamingAttachment;

import lombok.Data;

@Data
@Entity
@Table(name="uom_tab")
public class UOM {
	@Id
	@GeneratedValue(generator = "uom_gen_type_seq")
	@GenericGenerator(name="uom_gen_type_seq",strategy = "in.nit.generator.UOMCustomGenerator")
	@Column(name="uom_id_col")
	private String uid;
	@Column(name="uom_type_col")
	private String uomType;
	@Column(name="uom_model_col")
	private String uomModel;
	@Column(name="description_col")
	private String description;
}
